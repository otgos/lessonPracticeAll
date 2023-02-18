package com.practice.security.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.practice.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

//converting our users to user details
    private Long id;
    private String userName;
    @JsonIgnore // if this class sent to client side, then passowrd should not be visible
    private String password;

    //anything which extends from granted authority class
    private Collection<? extends GrantedAuthority> authorities;

    // method which returns from User Pojo class from UserDetails
    public static UserDetailsImpl build(User user){
        //method which returns granted authority form role
        List<SimpleGrantedAuthority> authorities = user.getRoles().stream().
                map(role->new SimpleGrantedAuthority(role.getName().name())).
                collect(Collectors.toList()); //collecting to List because roles are already in set, no way to get same elemnt
//we used allargs constructor above
        return new UserDetailsImpl(user.getId(), user.getUserName(), user.getPassword(), authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
