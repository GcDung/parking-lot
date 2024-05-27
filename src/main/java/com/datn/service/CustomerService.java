package com.datn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.datn.model.Customer;
import com.datn.model.User;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Page<Customer> getAllCustomerByKeyword(String keyword, Pageable pageable);
    Customer getCustomer(Long id);
    void deleteCustomer(Long id);
    Customer updateCustomer(Customer customer, Long id);
    Customer getCustomerByUser(User user);
}
