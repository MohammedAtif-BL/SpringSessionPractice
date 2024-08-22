package com.godigit.springexample.model;

import com.godigit.springexample.dto.AddressDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Long address_id;
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(AddressDTO addressDTO) {
        this.street = addressDTO.getStreet();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.zip = addressDTO.getZip();
    }
}
