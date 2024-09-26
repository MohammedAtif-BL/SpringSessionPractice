package com.godigit.springexample.service.serviceImpl;


import com.godigit.springexample.dto.HolderAddressDTO;
import com.godigit.springexample.dto.PolicyDTO;
import com.godigit.springexample.dto.PolicyHolderDTO;
import com.godigit.springexample.model.HolderAddress;
import com.godigit.springexample.model.Policy;
import com.godigit.springexample.model.PolicyHolder;
import com.godigit.springexample.repository.PolicyHolderRepository;
import com.godigit.springexample.service.PolicyHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyHolderServiceImpl implements PolicyHolderService {

    @Autowired
    private PolicyHolderRepository policyHolderRepository;

    public PolicyHolder createPolicyHolderWithDetails(PolicyHolderDTO policyHolderDTO) {
        PolicyHolder policyHolder = new PolicyHolder();
        policyHolder.setName(policyHolderDTO.getName());
        policyHolder.setEmail(policyHolderDTO.getEmail());

        // Adding policies
        for (PolicyDTO policyDTO : policyHolderDTO.getPolicies()) {
            Policy policy = new Policy();
            policy.setPolicyNumber(policyDTO.getPolicyNumber());
            policy.setType(policyDTO.getType());
            policyHolder.addPolicy(policy);
        }

        // Adding addresses
        for (HolderAddressDTO addressDTO : policyHolderDTO.getAddresses()) {
            HolderAddress address = new HolderAddress();
            address.setStreet(addressDTO.getStreet());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            address.setZipcode(addressDTO.getZipcode());
            policyHolder.addAddress(address);
        }

        return policyHolderRepository.save(policyHolder);
    }
}

