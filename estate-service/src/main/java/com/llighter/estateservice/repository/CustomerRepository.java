package com.llighter.estateservice.repository;

import com.llighter.estateservice.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Optional<Customer> findByNameAndMobile(String name, String mobile);
}
