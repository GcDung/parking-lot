package com.datn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.model.Report;
import com.datn.model.VnPayPayment;
import com.datn.repository.VnPayPaymentRepository;
import com.datn.service.VnPayPaymentService;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class VnPayPaymentServiceImpl implements VnPayPaymentService {
    @Autowired
    private VnPayPaymentRepository vnPayPaymentRepository;
    @Override
    public VnPayPayment addVnPayPayment(VnPayPayment vnPayPayment) {
        return vnPayPaymentRepository.save(vnPayPayment);
    }

    @Override
    public List<Report> getTotalRevenueByMonth(Date startTime, Date endTime) {
        List<Object[]> results = vnPayPaymentRepository.getTotalRevenueByMonth(startTime, endTime);
        if (results != null) {
            List<Report> reports = new ArrayList<>();
            for (Object[] result : results) {
                Report report = new Report();
                report.setMonth((Integer) result[0]);
                report.setYear((Integer) result[1]);
                report.setTotalAmount(((BigDecimal) result[2]).doubleValue());
                reports.add(report);
            }
            return reports;
        }else {
            return null;
        }
    }
}
