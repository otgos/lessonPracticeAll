package com.practice.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthTokenFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserDetailsService userDetailsService;

    // we adding one more filter to default filters
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        //create different for this
        //to get Jwt
        String jwtToken = parseJwt(request);

        //now we need to check if the token is valid...

        //write if method and then get into try and catch
        try {
            if(jwtToken!=null && jwtUtils.validateToken(jwtToken)){
                String userName = jwtUtils.getUserNameFromJwtToken(jwtToken); //why we need user name?? to be able to use in security context
                UserDetails userDetails = userDetailsService.loadUserByUsername(userName); //user which is recognized by security

                // we need to authenticate and place/populate it in security context
                //3 parameter bar

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails, //user itself
                                null,
                                userDetails.getAuthorities());//
                SecurityContextHolder.getContext().setAuthentication(authentication); //placing autheticated user in security context

                //now take it inside try and catch
            }
        } catch (UsernameNotFoundException e) {
            e.printStackTrace();
        }

        //there some default filter chaing --show it from slide-- if do not include our new filter it will be not added
        filterChain.doFilter(request, response);


    }

    //we need to get Token from request
    private String parseJwt(HttpServletRequest request){
        String header = request.getHeader("Authorization"); //in header's Authorization key
        if(StringUtils.hasText(header) && header.startsWith("Bearer ")){  //using strgin manipulation methods
            return header.substring(7);
        }
        return null;
    }

    //defining which paths should not be filtered
    //it is optional
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        AntPathMatcher antPathMatcher = new AntPathMatcher();
        return antPathMatcher.match("/register", request.getServletPath()) ||
                antPathMatcher.match("/login", request.getServletPath());
    }
}
