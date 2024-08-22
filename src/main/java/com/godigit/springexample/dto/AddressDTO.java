package com.godigit.springexample.dto;

import com.godigit.springexample.model.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private String street;
    private String city;
    private String state;
    private String zip;

    public AddressDTO(Address address) {
        this.street = address.getStreet();
        this.city = address.getCity();
        this.state = address.getState();
        this.zip = address.getZip();
    }
}


