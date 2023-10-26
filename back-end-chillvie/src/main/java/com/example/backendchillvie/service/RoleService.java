package com.example.backendchillvie.service;

import com.example.backendchillvie.projection.IRoleProjection;
import com.example.backendchillvie.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleService implements IRoleService{
    @Autowired
    private IRoleRepository iRoleRepository;
    @Override
    public List<IRoleProjection> getRoleByUserName(String name) {
        return iRoleRepository.getIRoleProjectionByRoleName(name);
    }
}
