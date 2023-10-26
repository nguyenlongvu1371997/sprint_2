package com.example.final_exam.service;

import com.example.final_exam.model.Employees;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IEmployeesService {
    Employees getEmployeeById(Long id);

    List<Employees> getListManager();

}
