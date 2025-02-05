package com.datn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.datn.model.Block;
import com.datn.model.ParkingLot;
import com.datn.model.ParkingSlot;
import com.datn.model.dto.BlockAndParkingSlot;
import com.datn.model.dto.ResponseMessage;
import com.datn.service.BlockService;
import com.datn.service.ParkingLotService;
import com.datn.service.ParkingSlotService;

import java.util.List;

@RestController
@RequestMapping("/blocks")
@CrossOrigin(origins = "*")
public class BlockController {
    @Autowired
    private BlockService blockService;
    @Autowired
    private ParkingLotService parkingLotService;
    @Autowired
    private ParkingSlotService parkingSlotService;

    @GetMapping("admin/all")
    public ResponseEntity<List<Block>> getBlocksByParkingLot() {
        return new ResponseEntity(blockService.getAllBlock(), HttpStatus.OK);
    }

    @PostMapping("admin/add/{id}")
    public ResponseEntity<Block> createBlock(@RequestBody BlockAndParkingSlot blockAndParkingSlot, @PathVariable Long id) {
        ParkingLot parkingLot = parkingLotService.getParkingLot(id);
        Block block = new Block();
        block.setParkingLot(parkingLot);
        block.setBlockCode(blockAndParkingSlot.getBlock().getBlockCode());
        Block newBlock = blockService.createBlock(block);
        int numberOfParkingSlots = blockAndParkingSlot.getNumberOfParkingSlots();
        for (int i=0; i<numberOfParkingSlots; i++) {
            ParkingSlot parkingSlot = new ParkingSlot();
            parkingSlot.setBlock(newBlock);
            parkingSlot.setSlotNumber(i+1);
            parkingSlotService.addParkingSlot(parkingSlot);
        }
        return new ResponseEntity(blockService.createBlock(block), HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<?> deleteBlock(@PathVariable Long id) {
        blockService.deleteBlock(id);
        return new ResponseEntity(new ResponseMessage("Deleted Block Success"), HttpStatus.OK);
    }

    @PutMapping("admin/update/{id}")
    public ResponseEntity<Block> updateBlock(@RequestBody Block block, @PathVariable Long id) {
        return new ResponseEntity(blockService.updateBlock(block, id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Block>> getBlocksByParkingLot(@RequestParam Long parkingLotId) {
        ParkingLot parkingLot = parkingLotService.getParkingLot(parkingLotId);
        return new ResponseEntity(blockService.getBlockByParkingLot(parkingLot), HttpStatus.OK);
    }
}
