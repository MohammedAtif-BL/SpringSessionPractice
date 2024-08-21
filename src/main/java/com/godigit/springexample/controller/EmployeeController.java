package com.godigit.springexample.controller;

import com.godigit.springexample.dto.EmployeeDTO;
import com.godigit.springexample.model.Employee;
import com.godigit.springexample.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee")
    public String message(){
        return "Hello World from Employee Controller";
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeByID(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
}