package com.datn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.datn.model.BookingHistory;
import com.datn.model.Customer;

import java.util.List;

public interface BookingHistoryService {
    BookingHistory addBookingHistory(BookingHistory bookingHistory);
    BookingHistory getBookingHistory(Long id);
    Page<BookingHistory> getAllBookingHistories(Pageable pageable);
    Page<BookingHistory> getBookingHistoriesByCustomer(Customer customer, Pageable pageable);
    void addBookingHistories(List<BookingHistory> histories);
}
