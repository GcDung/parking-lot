package com.datn.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.datn.model.RegularPass;
import com.datn.service.RegularPassService;

import java.sql.Date;
import java.util.List;

@Component
public class RegularPassScheduler {
    private static final Logger logger = LoggerFactory.getLogger(BookingScheduler.class);
    @Autowired
    private RegularPassService regularPassService;

    @Scheduled(fixedRate = 300000)
    public void checkNewAndResetRenew() {
        List<RegularPass> regularPasses = regularPassService.getAllRegularPass();

        Date today = new Date(System.currentTimeMillis());
        for (RegularPass regularPass : regularPasses) {
            if (regularPass.getStartDate().equals(today) || regularPass.getStartDate().before(today)) {
                regularPass.setStatusNow(true);
                regularPassService.updateRegularPass(regularPass, regularPass.getId());
            }

            if (!regularPassService.checkRenew(regularPass)) {
                regularPass.setRenewPair(false);
                regularPass.setStatusNow(false);
                regularPassService.updateRegularPass(regularPass, regularPass.getId());
            }
        }
    }
}
