package com.godigit.springexample.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EmployeeDTO {
    @NotNull
    private Long id;
    @NotEmpty(message = "Name Should Not Be Empty")
    @Pattern(regexp = "^[A-Z][a-z]{2,}$", message = "Name is Invalid")
    private String name;

    @Email
    @NotBlank(message = "Email Should not be Empty")
    private String email;

    @Min(value=10000,message = "Salary should not be less than 10000")
    @Max(value = 20000,message = "Salary should not be greater than 20000")
    private Double salary;

    @Past(message = "Birthdate Should be in past")
    private LocalDate birthDate;

    @PastOrPresent(message = "Rigestration must be Past or Present Date")
    private LocalDate registrationDate;

    @FutureOrPresent
    private LocalDate joiningDate;

    @Future
    private LocalDate event;

}
