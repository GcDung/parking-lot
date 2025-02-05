package com.datn.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.datn.model.Customer;
import com.datn.model.ParkingSlot;
import com.datn.model.ParkingSlotReservation;

import java.sql.Date;
import java.util.List;

@Repository
public interface ParkingSlotReservationRepository extends JpaRepository<ParkingSlotReservation, Long> {
    Page<ParkingSlotReservation> findAll(Pageable pageable);
    Page<ParkingSlotReservation> findByBookingDate(Date date, Pageable pageable);
    Page<ParkingSlotReservation> findByCustomer(Customer customer, Pageable pageable);
    List<ParkingSlotReservation> findByParkingSlot(ParkingSlot parkingSlot);
    @Query(value = "SELECT * FROM ParkingSlotReservation r WHERE DATE_ADD(r.startTimestamp, INTERVAL r.durationInMinutes MINUTE) < CURRENT_TIMESTAMP", nativeQuery = true)
    List<ParkingSlotReservation> findPastReservations();
}
