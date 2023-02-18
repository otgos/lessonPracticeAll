package com.practice.security;

import com.practice.security.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    /*
        In this class:
            1. Create/build JWT
            2. Validate JWT
            3. from JWT generate userName
     */

    //we need to have secret key
    private String jwtSecret = "sboot";

    //jwt token expiration time: 24 hours
    private long jwtExpiration = 86400000; //24*60*60*1000 = 24hours


    //*********** CREATE JW TOKEN *************
    //to create TOKEN we need 3 things
        //userName
        //expire date
        //secret key
    public String createToken(Authentication authentication){ //need to reach authenticated user. user
        // is autheticated here

        //here we are getting currently logged in user detail from below information in user detail service data format
       UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal(); //return user from security context in
        // user Details data format ----go to UserDetails Implclass and implement from UserDetails
        //now we have everything to create jwt token

        return Jwts.builder().
                setSubject(userDetails.getUsername()). //jwt token will be created by userName
                setIssuedAt(new Date()).              //when jwt token created
                setExpiration(new Date(new Date().getTime()+jwtExpiration)). //set expiration date
                signWith(SignatureAlgorithm.HS512, jwtSecret). //encoding method with secret key
                compact();  //compact everything

    }

    //*********** VALIDATE TOKEN ****************

    public boolean validateToken(String token){
        //this may bring some exepctions dep show exeptions and then click surround with try catch
        try {
            // we are doign hard coding.. by providing jwtSecret and token.. it it will validate token
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token); //validating token
            return true;
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        } catch (UnsupportedJwtException e) {
            e.printStackTrace();
        } catch (MalformedJwtException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return false; // if it works ok returns true, if it throws any of exeptions then returns false
    }

    //********** take out user name from JWT token ***************
    public String getUserNameFromJwtToken(String token){ //if we reach to token body using getSubject we get userName
        return Jwts.parser().setSigningKey(jwtSecret).
                parseClaimsJws(token).
                getBody().
                getSubject(); //while bulding jwt token we have setSubject now we we getting subject
                                // userName is unique, after we get username, we reach othe info
    }

}
