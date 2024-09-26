package com.godigit.springexample.repository;

import com.godigit.springexample.model.HolderAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolderAddressRepository extends JpaRepository<HolderAddress,Long> {
}
