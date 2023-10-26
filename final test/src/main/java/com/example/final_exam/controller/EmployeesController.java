package com.example.final_exam.controller;

import com.example.final_exam.model.Employees;
import com.example.final_exam.service.IEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/employees")
@RestController
public class EmployeesController {
    @Autowired
    private IEmployeesService iEmployeesService;

    @GetMapping("/employee")
    public ResponseEntity<Employees> getEmployeeById(@RequestParam("id")Long id){
        Employees employees = iEmployeesService.getEmployeeById(id);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/manager")
    public ResponseEntity<List<Employees>> getListManager(){
        List<Employees> list = iEmployeesService.getListManager();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
