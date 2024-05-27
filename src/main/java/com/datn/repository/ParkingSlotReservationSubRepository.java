package com.datn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.datn.model.dto.ParkingSlotReservationSub;

@Repository
public interface ParkingSlotReservationSubRepository extends JpaRepository<ParkingSlotReservationSub, Long> {
}
