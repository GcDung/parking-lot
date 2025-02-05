package com.datn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.datn.model.Customer;
import com.datn.model.User;
import com.datn.repository.CustomerRepository;
import com.datn.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Page<Customer> getAllCustomerByKeyword(String keyword, Pageable pageable) {
        return customerRepository.searchByKeyword(keyword, pageable);
    }

    @Override
    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) {
        return customerRepository.findById(id).map(cus -> {
            cus.setVehicleNumber(customer.getVehicleNumber());
            cus.setRegistrationDate(customer.getRegistrationDate());
            cus.setRegularCustomer(customer.isRegularCustomer());
            cus.setContactNumber(customer.getContactNumber());
            cus.setUser(customer.getUser());
            return customerRepository.save(cus);
        }).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    @Override
    public Customer getCustomerByUser(User user) {
        return customerRepository.findByUser(user);
    }
}
