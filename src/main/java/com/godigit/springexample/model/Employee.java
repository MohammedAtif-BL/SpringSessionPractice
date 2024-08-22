package com.godigit.springexample.model;

import com.godigit.springexample.dto.AddressDTO;
import com.godigit.springexample.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee_table")
public class Employee {
    @Id
    @GeneratedValue
    private Long emp_id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_email")
    private String email;

    private String password;

    @ElementCollection
    @CollectionTable(name = "department_table",joinColumns = @JoinColumn(name="employee_id"))
    private List<String> department;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;

    public Employee(EmployeeDTO employeeDTO, Address address) {
        this.name = employeeDTO.getName();
        this.email = employeeDTO.getEmail();
        this.department = employeeDTO.getDepartment();
        this.password = employeeDTO.getPassword();
        this.address = address;
    }
}
