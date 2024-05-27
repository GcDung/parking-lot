package com.datn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.datn.model.Block;
import com.datn.model.ParkingSlot;

import java.util.List;

public interface ParkingSlotService {
    Page<ParkingSlot> getAllParkingSlot(Pageable pageable);
    ParkingSlot addParkingSlot(ParkingSlot parkingSlot);
    ParkingSlot updateParkingSlot(ParkingSlot parkingSlot, Long id);
    void deleteParkingSlot(Long id);

    List<ParkingSlot> getParkingSlotByBlock(Block block);
    List<ParkingSlot> getParkingSlotByBlockId(Long blockId);
    ParkingSlot getParkingSlot(Long id);
    int countUsedParkingSlots(Long id);
    List<ParkingSlot> getAllParkingSlots();
    void updateParkingSlots(List<ParkingSlot> parkingSlots);
    int findMaxSlotNumber(Long blockId);
    int countParkingSlotsByBlock(Block block);
    ParkingSlot getParkingSlotBySlotNumberAndBlockId(int slotNumber, Long blockId);
    ParkingSlot getParkingSlotBySlotNumberAndBlock(int slotNumber, Block block);
}
