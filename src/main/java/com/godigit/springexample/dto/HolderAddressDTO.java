package com.godigit.springexample.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HolderAddressDTO {
    private String street;
    private String city;
    private String state;
    private String zipcode;
}
