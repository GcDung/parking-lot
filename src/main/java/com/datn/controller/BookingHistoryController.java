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

import com.datn.model.BookingHistory;
import com.datn.model.Customer;
import com.datn.model.User;
import com.datn.security.jwt.JwtProvider;
import com.datn.security.jwt.JwtTokenFilter;
import com.datn.service.BookingHistoryService;
import com.datn.service.CustomerService;
import com.datn.service.UserService;

@RestController
@RequestMapping("/booking-histories")
@CrossOrigin(origins = "*")
public class BookingHistoryController {
    @Autowired
    private BookingHistoryService bookingHistoryService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private JwtTokenFilter jwtTokenFilter;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<Page<BookingHistory>> getAllBookingHistories(HttpServletRequest request,
                                                                       @RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "10") int size,
                                                                       @RequestParam(defaultValue = "id") String sortBy,
                                                                       @RequestParam(defaultValue = "desc") String order) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sortBy));
        String jwt = jwtTokenFilter.getJwt(request);
        String username = jwtProvider.getUsernameFromToken(jwt);
        User user = userService.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
        Customer customer = customerService.getCustomerByUser(user);
        return new ResponseEntity(bookingHistoryService.getBookingHistoriesByCustomer(customer, pageable), HttpStatus.OK);
    }

    @GetMapping("/admin/all")
    public ResponseEntity<Page<BookingHistory>> getAllBookingHistories(@RequestParam(defaultValue = "0") int page,
                                                                       @RequestParam(defaultValue = "10") int size,
                                                                       @RequestParam(defaultValue = "id") String sortBy,
                                                                       @RequestParam(defaultValue = "desc") String order) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(order), sortBy));
        return new ResponseEntity(bookingHistoryService.getAllBookingHistories(pageable), HttpStatus.OK);
    }
}
