package com.godigit.springexample.service;

import com.godigit.springexample.dto.EmployeeDTO;
import com.godigit.springexample.dto.LoginDTO;
import com.godigit.springexample.exception.EmployeeNotFoundException;
import com.godigit.springexample.model.Address;
import com.godigit.springexample.model.Employee;
import com.godigit.springexample.repository.AddressRepository;
import com.godigit.springexample.repository.EmployeeRepository;
import com.godigit.springexample.util.TokenUtillity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    TokenUtillity tokenUtillity;

    @Autowired
    AddressRepository addressRepository;

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
        Address address = new Address(employeeDTO.getAddress());

        Employee employee = new Employee(employeeDTO,addressRepository.save(address));
        Employee saveEmployee =  employeeRepository.save(employee);
        return mapToDTO(saveEmployee);
    }

    private EmployeeDTO mapToDTO(Employee saveEmployee) {
        return new EmployeeDTO(saveEmployee);
    }

    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Employee getEmployeeById(Long id) {
       return employeeRepository.findById(id).orElseThrow(()-> new EmployeeNotFoundException("EMployee not found"));
    }

    public List<Employee> getEmployeeByDepartment(String dept) {
        return employeeRepository.findEmployeeByDepartment(dept);
    }

    public ResponseEntity<?> logicUser(LoginDTO loginDTO) {
       Employee employee = employeeRepository.findByName(loginDTO.getName());
       if(employee!=null && employee.getPassword().equals(loginDTO.getPassword())){
                String token = tokenUtillity.createToken(employee.getEmp_id());

           Map<String, Object> response = new HashMap<>();
           response.put("message","Login Successful");
           response.put("token",token);
           return new ResponseEntity<>(response, HttpStatus.OK);
       } else {
           throw new RuntimeException("Login Failed");
       }
    }

    public Employee getByToken(String token) {
        Long id = tokenUtillity.decodeToken(token);
        return getEmployeeById(id);
    }
}
