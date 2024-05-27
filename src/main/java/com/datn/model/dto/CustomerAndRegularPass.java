package com.datn.model.dto;

import com.datn.model.Customer;
import com.datn.model.RegularPass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAndRegularPass {
    Customer customer;
    RegularPass regularPass;
}
