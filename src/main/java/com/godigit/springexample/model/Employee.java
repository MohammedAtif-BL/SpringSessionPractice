package com.godigit.springexample.model;

import com.godigit.springexample.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_table")
public class Employee {
    @Id
    @GeneratedValue
    private Long emp_Id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_email")
    private String email;

    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.email = employeeDTO.getEmail();
    }
}
