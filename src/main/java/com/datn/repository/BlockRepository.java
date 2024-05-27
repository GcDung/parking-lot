package com.datn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datn.model.Block;
import com.datn.model.ParkingLot;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block, Long> {
    List<Block> findByParkingLot(ParkingLot parkingLot);
    Block findByParkingLotAndBlockCode(ParkingLot parkingLot, String blockCode);
    List<Block> findByParkingLotId(Long parkingLotId);
}
