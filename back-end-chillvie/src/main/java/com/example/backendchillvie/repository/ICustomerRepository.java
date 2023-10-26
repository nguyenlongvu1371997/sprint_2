package com.example.backendchillvie.repository;

import com.example.backendchillvie.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(nativeQuery = true, value = "select c.id from customer c join app_user a on c.app_user_id = a.id where a.id = :id")
    Long getCustomerIdByAppUser(@Param("id")Long id);
}

