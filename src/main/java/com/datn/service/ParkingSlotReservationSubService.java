package com.datn.service;

import com.datn.model.ParkingSlotReservation;
import com.datn.model.dto.ParkingSlotReservationSub;

public interface ParkingSlotReservationSubService {
    ParkingSlotReservationSub createParkingSlotReservationSub(ParkingSlotReservation parkingSlotReservation);
    void deleteParkingSlotReservationSub(Long id);
    ParkingSlotReservationSub updateParkingSlotReservationSub(ParkingSlotReservationSub parkingSlotReservationSub, Long id);
    ParkingSlotReservationSub getParkingSlotReservationSub(Long id);
}
