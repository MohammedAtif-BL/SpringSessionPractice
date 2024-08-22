package com.godigit.springexample.dto;

import com.godigit.springexample.model.Employee;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class EmployeeDTO {

    @NotEmpty(message = "Name Should Not Be Empty")
    @Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "Name is Invalid")
    private String name;

    @Email
    @NotBlank(message = "Email Should not be Empty")
    private String email;

    private String password;

    private List<String> department;

   private AddressDTO address;

    public EmployeeDTO(Employee employee) {
        this.name = employee.getName();
        this.email = employee.getEmail();
        this.department = employee.getDepartment();
        this.address = new AddressDTO(employee.getAddress());
        this.password = employee.getPassword();
    }
}
