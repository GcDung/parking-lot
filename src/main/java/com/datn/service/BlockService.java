package com.datn.service;

import java.util.List;

import com.datn.model.Block;
import com.datn.model.ParkingLot;

public interface BlockService {
    Block createBlock(Block block);
    Block updateBlock(Block block, Long id);
    void deleteBlock(Long id);
    List<Block> getBlockByParkingLot(ParkingLot parkingLot);
    List<Block> getAllBlock();
    Block getBlock(Long id);
    Block getBlockByParkingLotAndBlockCode(ParkingLot parkingLot, String blockCode);
    List<Block> getBlockByParkingLotId(Long parkingLotId);
}
