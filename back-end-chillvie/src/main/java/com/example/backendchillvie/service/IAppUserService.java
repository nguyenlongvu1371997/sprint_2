package com.example.backendchillvie.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IAppUserService extends UserDetailsService {
    Optional<Long> getIdUserByUserName(String name);
}
