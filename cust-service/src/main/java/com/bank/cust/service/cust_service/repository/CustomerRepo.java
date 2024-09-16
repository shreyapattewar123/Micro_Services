package com.bank.cust.service.cust_service.repository;

import com.bank.cust.service.cust_service.entity.customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<customer,Integer> {
}
