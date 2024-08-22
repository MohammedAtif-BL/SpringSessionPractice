package com.godigit.springexample.controller;

import com.godigit.springexample.dto.LoginDTO;
import com.godigit.springexample.model.Employee;
import com.godigit.springexample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/api")
    public ResponseEntity<?> userLogin(@RequestBody LoginDTO loginDTO){
        try{
            return ResponseEntity.ok( employeeService.logicUser(loginDTO));

        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or Password");
        }
    }

    @GetMapping
    public Employee getBytoken(@RequestHeader String token){
        return employeeService.getByToken(token);
    }
}
