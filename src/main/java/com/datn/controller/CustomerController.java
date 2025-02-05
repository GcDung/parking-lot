package com.datn.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.datn.model.Customer;
import com.datn.model.User;
import com.datn.model.dto.ResponseMessage;
import com.datn.security.jwt.JwtProvider;
import com.datn.security.jwt.JwtTokenFilter;
import com.datn.service.CustomerService;
import com.datn.service.UserService;

@RestController
@RequestMapping("/customers")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @GetMapping("admin")
    public ResponseEntity<Page<Customer>> getAllCustomer(@RequestParam(defaultValue = "") String keyword,
                                                 @RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size,
                                                 @RequestParam(defaultValue = "id") String sortBy,
                                                 @RequestParam(defaultValue = "desc") String order) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.desc(sortBy)));
        return new  ResponseEntity<>(customerService.getAllCustomerByKeyword(keyword, pageable), HttpStatus.OK);
    }

    @PostMapping("admin/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);
    }

//    @PutMapping("/update")
//    public ResponseEntity<Customer> updateCustomer(HttpServletRequest request, @RequestBody Customer customer) {
//        String token = jwtTokenFilter.getJwt(request);
//        String username = jwtProvider.getUsernameFromToken(token);
//        User user = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
//        Customer customer1 = customerService.getCustomerByUser(user);
//        customer1.setVehicleNumber(customer.getVehicleNumber());
//        customer1.setRegistrationDate(customer.getRegistrationDate());
//        customer1.setRegularCustomer(customer.isRegularCustomer());
//        customer1.setContactNumber(customer.getContactNumber());
//        customer1.setUser(user);
//        return new ResponseEntity<>(customerService.updateCustomer(customer1, customer1.getId()), HttpStatus.OK);
//    }

    @DeleteMapping("admin/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(new ResponseMessage("deleted"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id) {
        return new ResponseEntity<>(customerService.getCustomer(id), HttpStatus.OK);
    }
}
