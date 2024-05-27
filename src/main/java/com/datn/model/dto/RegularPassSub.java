package com.datn.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import com.datn.model.Customer;

@Entity
@Data
@NoArgsConstructor
public class RegularPassSub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Customer customer;

    private Date purchaseDate;
    private Date startDate;
    private Date endDate;
    private int durationInDays;
    private int cost;
    private boolean pair = false;
    private boolean renewPair = false;
    private boolean statusNow = false;
}
