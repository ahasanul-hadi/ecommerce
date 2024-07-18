package com.wsd.ecommerce.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public Optional<CustomerEntity> findById(Long id){
        return customerRepository.findById(id);
    }
}
