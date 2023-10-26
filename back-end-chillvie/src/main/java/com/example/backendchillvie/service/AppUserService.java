package com.example.backendchillvie.service;

import com.example.backendchillvie.projection.IRoleProjection;
import com.example.backendchillvie.projection.IUserProjection;
import com.example.backendchillvie.projection.UserProjection;
import com.example.backendchillvie.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppUserService implements IAppUserService{
    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IRoleService iRoleService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        IUserProjection iUserProjection = iUserRepository.getIUserProjectionByUserName(username);
        if (iUserProjection == null) {
            throw new UsernameNotFoundException("User name or password is wrong");
        }
        System.out.println("username >>> " + iUserProjection.getUsername());
        System.out.println("password >>> " + iUserProjection.getPassword());
        List<IRoleProjection> roleList = iRoleService.getRoleByUserName(username);
        List<GrantedAuthority> grantList = new ArrayList<>();
        for (IRoleProjection role : roleList) {
            grantList.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new UserProjection(
                iUserProjection.getUsername(),
                iUserProjection.getPassword(),
                grantList) {
        };
    }

    @Override
    public Optional<Long> getIdUserByUserName(String name) {
        return iUserRepository.getIdUserByUserName(name);
    }
}
