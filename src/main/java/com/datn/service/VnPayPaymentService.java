package com.datn.service;

import java.sql.Date;
import java.util.List;

import com.datn.model.Report;
import com.datn.model.VnPayPayment;

public interface VnPayPaymentService {
    VnPayPayment addVnPayPayment(VnPayPayment vnPayPayment);

    List<Report> getTotalRevenueByMonth(Date startTime, Date endTime);
}
