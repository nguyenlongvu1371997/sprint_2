package com.example.backendchillvie.repository;

import com.example.backendchillvie.model.RoleUser;
import com.example.backendchillvie.projection.IRoleProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.management.relation.Role;
import java.util.List;

public interface IRoleRepository extends JpaRepository<RoleUser, Long> {
    @Query(nativeQuery = true, value = "select r.name as roleName from app_user a join role_user r " +
            "on r.id = a.role_user_id  where a.name = :name")
    List<IRoleProjection> getIRoleProjectionByRoleName(@Param("name")String userName);
}
