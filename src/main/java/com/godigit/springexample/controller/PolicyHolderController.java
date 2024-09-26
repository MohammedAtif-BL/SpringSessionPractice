package com.godigit.springexample.controller;

import com.godigit.springexample.dto.PolicyHolderDTO;
import com.godigit.springexample.model.PolicyHolder;
import com.godigit.springexample.service.PolicyHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/policyholders")
public class PolicyHolderController {

    @Autowired
    private PolicyHolderService policyHolderService;

    /**
     * Purpose: this API(application programming interface) is created for
     * registering new user into system
     *
     * @param policyHolderDTO response coming from front end will going to handle in
     *                    this controller class as this request is register request
     *                    so we are mapping this request into policyHolderDTO POJO class
     *                    by using @RequestBody and then giving DTO to service to
     *                    process
     * @return returns ResponseEntity which is holding the policyHolder object and
     *         HttpStatus in that entity
     */
    @PostMapping
    public ResponseEntity<PolicyHolder> createPolicyHolderWithPolicies(@RequestBody PolicyHolderDTO policyHolderDTO) {
        PolicyHolder savedPolicyHolder = policyHolderService.createPolicyHolderWithDetails(policyHolderDTO);
        return new ResponseEntity<>(savedPolicyHolder, HttpStatus.CREATED);
    }
/**
 *
 */
}
