package com.datn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datn.model.RegularPass;
import com.datn.model.dto.RegularPassSub;
import com.datn.repository.RegularPassSubRepository;
import com.datn.service.RegularPassSubService;

@Service
public class RegularPassSubServiceImpl implements RegularPassSubService {
    @Autowired
    private RegularPassSubRepository regularPassSubRepository;
    @Override
    public RegularPassSub createRegularPassSub(RegularPass regularPass) {
        RegularPassSub regularPassSub = new RegularPassSub();
        regularPassSub.setCustomer(regularPass.getCustomer());
        regularPassSub.setPurchaseDate(regularPass.getPurchaseDate());
        regularPassSub.setStartDate(regularPass.getStartDate());
        regularPassSub.setEndDate(regularPass.getEndDate());
        regularPassSub.setDurationInDays(regularPass.getDurationInDays());
        regularPassSub.setCost(regularPass.getCost());
        regularPassSub.setPair(regularPass.isPair());
        regularPassSub.setRenewPair(regularPass.isRenewPair());
        regularPassSub.setStatusNow(regularPass.isStatusNow());
        return regularPassSubRepository.save(regularPassSub);
    }

    @Override
    public RegularPassSub updateRegularPassSub(RegularPassSub regularPassSub) {
        return regularPassSubRepository.findById(regularPassSub.getId()).map(rp -> {
            rp.setCustomer(regularPassSub.getCustomer());
            rp.setPurchaseDate(regularPassSub.getPurchaseDate());
            rp.setStartDate(regularPassSub.getStartDate());
            rp.setEndDate(regularPassSub.getEndDate());
            rp.setDurationInDays(regularPassSub.getDurationInDays());
            rp.setCost(regularPassSub.getCost());
            rp.setPair(regularPassSub.isPair());
            rp.setRenewPair(regularPassSub.isRenewPair());
            rp.setStatusNow(regularPassSub.isStatusNow());
            return regularPassSubRepository.save(rp);
        }).orElseGet(() -> regularPassSubRepository.save(regularPassSub));
    }

    @Override
    public RegularPassSub getRegularPassSub(Long id) {
        return regularPassSubRepository.findById(id).orElseThrow(() -> new RuntimeException("Regular pass sub not found"));
    }

    @Override
    public void deleteRegularPassSub(Long id) {
        regularPassSubRepository.deleteById(id);
    }
}
