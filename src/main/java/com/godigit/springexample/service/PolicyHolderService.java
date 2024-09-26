package com.godigit.springexample.service;

import com.godigit.springexample.dto.HolderAddressDTO;
import com.godigit.springexample.dto.PolicyDTO;
import com.godigit.springexample.dto.PolicyHolderDTO;
import com.godigit.springexample.model.HolderAddress;
import com.godigit.springexample.model.Policy;
import com.godigit.springexample.model.PolicyHolder;
import com.godigit.springexample.repository.PolicyHolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface PolicyHolderService {

    public PolicyHolder createPolicyHolderWithDetails(PolicyHolderDTO policyHolderDTO);
}
