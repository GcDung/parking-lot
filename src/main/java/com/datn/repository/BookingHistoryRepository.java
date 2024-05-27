package com.datn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datn.model.BookingHistory;
import com.datn.model.Customer;

@Repository
public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Long>{
    Page<BookingHistory> findAll(Pageable pageable);
    Page<BookingHistory> findByCustomer(Customer customer, Pageable pageable);
}
