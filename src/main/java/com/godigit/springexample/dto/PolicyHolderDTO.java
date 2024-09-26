package com.godigit.springexample.dto;

import com.godigit.springexample.model.HolderAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyHolderDTO {

    private String name;
    private String email;
    private List<PolicyDTO> policies;
    private List<HolderAddressDTO> addresses;
}

