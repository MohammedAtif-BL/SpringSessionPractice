package com.godigit.springexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PolicyHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "policyHolder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("policyHolder") // Prevent infinite loop
    private List<Policy> policies = new ArrayList<>();


    @OneToMany(mappedBy = "policyHolder", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("policyHolder") // Prevent infinite loop
    private List<HolderAddress> addresses = new ArrayList<>();

    public void addPolicy(Policy policy) {
        policies.add(policy);
        policy.setPolicyHolder(this);
    }

    public void removePolicy(Policy policy) {
        policies.remove(policy);
        policy.setPolicyHolder(null);
    }

    public void addAddress(HolderAddress address) {
        addresses.add(address);
        address.setPolicyHolder(this);
    }

    public void removeAddress(HolderAddress address) {
        addresses.remove(address);
        address.setPolicyHolder(null);
    }
}

