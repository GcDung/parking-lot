package com.datn.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.datn.model.Block;
import com.datn.model.ParkingLot;
import com.datn.model.ParkingSlot;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailableParkingSlotsInfo {
    private ParkingLot parkingLot;
    private Block block;
    private List<ParkingSlot> availableParkingSlots;
}
