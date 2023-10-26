package com.example.final_exam.service;

import com.example.final_exam.model.Employees;
import com.example.final_exam.repository.IEmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesService implements IEmployeesService{
    @Autowired
    private IEmployeesRepository iEmployeesRepository;
    @Override
    public Employees getEmployeeById(Long id) {
        return iEmployeesRepository.getEmployeeById(id);
    }

    @Override
    public List<Employees> getListManager() {
        return iEmployeesRepository.getListManager();
    }
}
