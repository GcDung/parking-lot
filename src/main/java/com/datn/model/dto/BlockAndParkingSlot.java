package com.datn.model.dto;

import com.datn.model.Block;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlockAndParkingSlot {
    private Block block;
    private int numberOfParkingSlots;
}