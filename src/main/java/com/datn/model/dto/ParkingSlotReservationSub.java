package com.datn.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import com.datn.model.Customer;
import com.datn.model.ParkingSlot;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingSlotReservationSub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    private Timestamp startTimestamp;
    private int durationInMinutes;
    private Timestamp bookingDate;

    @ManyToOne
    private ParkingSlot parkingSlot;

    private int cost;
    @Column(nullable = false)
    private String confirmName;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String confirmVehicleNumber;
    private boolean pair = false;
}
