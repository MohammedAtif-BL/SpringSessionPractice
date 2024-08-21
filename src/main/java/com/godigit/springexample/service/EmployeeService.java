package com.godigit.springexample.service;

import com.godigit.springexample.dto.EmployeeDTO;
import com.godigit.springexample.exception.EmployeeNotFoundException;
import com.godigit.springexample.model.Employee;
import com.godigit.springexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee createEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee(employeeDTO);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
       return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("EMployee not found"));
    }
}
