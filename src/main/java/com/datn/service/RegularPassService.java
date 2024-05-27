package com.datn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.datn.model.Customer;
import com.datn.model.RegularPass;
import com.datn.model.dto.RegularPassSub;

import java.util.List;

public interface RegularPassService {
    RegularPass addRegularPass(RegularPass regularPass);
    Page<RegularPass> getAllRegularPass(Pageable pageable);
    RegularPass getRegularPass(Long id);
    void deleteRegularPass(Long id);
    RegularPass updateRegularPass(RegularPass regularPass, Long id);
    RegularPass getRegularByCustomer(Customer customer);
    Page<RegularPass> getByCustomerName(String name, Pageable pageable);
    boolean checkRenew(RegularPass regularPass);
    List<RegularPass> getAllRegularPass();
    RegularPass createRegularPassBySub(RegularPassSub regularPassSub);
}
