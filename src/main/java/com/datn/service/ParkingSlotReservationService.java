package com.datn.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.datn.model.*;
import com.datn.model.dto.AvailableParkingSlotsInfo;
import com.datn.model.dto.ParkingSlotReservationSub;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public interface ParkingSlotReservationService {
    Page<ParkingSlotReservation> getAllParkingSlotReservations(Pageable pageable);
    ParkingSlotReservation createParkingSlotReservation(ParkingSlotReservation parkingSlotReservation);
    Page<ParkingSlotReservation> getAllParkingSlotReservations(Date date, Pageable pageable);
    ParkingSlotReservation updateParkingSlotReservation(ParkingSlotReservation parkingSlotReservation, Long id);
    void deleteParkingSlotReservation(Long id);
    ParkingSlotReservation getParkingSlotReservation(Long id);
    Page<ParkingSlotReservation> getAllParkingSlotReservationsByCustomer(Customer customer, Pageable pageable);
    List<ParkingSlot> findAvailableParkingSlots(int slotNumber, Date bookingDate, int durationInMinutes);
    List<ParkingSlotReservation> getParkingSlotReservationsByParkingSlot(ParkingSlot parkingSlot);
    List<AvailableParkingSlotsInfo> findAvailableParkingSlotsAndBlockAndParkingLot(Timestamp startTimestamp, int durationInMinutes, Long id);
    List<ParkingSlotReservation> findPastReservations();
    List<ParkingSlotReservation> getAllParkingSlotReservations();
    ParkingSlotReservation createParkingSlotReservationBySub(ParkingSlotReservationSub parkingSlotReservationSub);
}
