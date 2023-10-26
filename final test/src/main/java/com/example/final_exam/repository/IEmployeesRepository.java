package com.example.final_exam.repository;

import com.example.final_exam.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IEmployeesRepository extends JpaRepository<Employees, Long> {
    @Query(nativeQuery = true,value = "select * from employees e where id = :id and flag_deleted=false")
    Employees getEmployeeById(@Param("id")Long id);

    @Query(nativeQuery = true, value = "select * from employees " +
            "where flag_deleted=false and positions_id=2 and rooms_id is null")
    List<Employees> getListManager();
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update employees set rooms_id = :rooms_id where id=:id")
    void updateEmployee(@Param("rooms_id")Long roomId, @Param("id")Long id);


}
