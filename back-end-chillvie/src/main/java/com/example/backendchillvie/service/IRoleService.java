package com.example.backendchillvie.service;

import com.example.backendchillvie.projection.IRoleProjection;

import java.util.List;

public interface IRoleService {
    List<IRoleProjection> getRoleByUserName(String name);
}
