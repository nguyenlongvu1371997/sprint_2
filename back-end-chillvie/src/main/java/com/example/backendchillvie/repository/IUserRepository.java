package com.example.backendchillvie.repository;

import com.example.backendchillvie.model.AppUser;
import com.example.backendchillvie.projection.IUserProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<AppUser, Long> {
    @Query(nativeQuery = true, value = "select name as username, password_user as password " +
            "from app_user where name = :name")
    IUserProjection getIUserProjectionByUserName(@Param("name") String userName);

    @Query(nativeQuery = true, value = "select id from app_user where name = :name")
    Optional<Long> getIdUserByUserName(@Param("name") String userName);
}
