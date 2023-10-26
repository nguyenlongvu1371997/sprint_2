package com.example.backendchillvie.projection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Collection;
import java.util.List;

public class UserProjection implements UserDetails, Validator {
   private String username;
   private String password;
    private Collection<GrantedAuthority> grantList;
//    public UserProjection(String username, String password, List<GrantedAuthority> grantList) {
////        haizz contructor có tham só nhưng k có chi trong ni hết =)) có lombok k xài đi xài ni haha
//    }

    public UserProjection(String username, String password, List<GrantedAuthority> grantList) {
        this.username = username;
        this.password = password;
        this.grantList = grantList;
    }

    public UserProjection() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantList;
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
