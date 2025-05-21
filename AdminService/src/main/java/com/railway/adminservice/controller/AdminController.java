package com.railway.adminservice.controller;

import com.railway.adminservice.service.AdminService;
import com.railway.traininformationservice.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add")
    public ResponseEntity<Train> addTrain(@RequestBody Train train){
        adminService.addTrain(train);
        return ResponseEntity.ok(train);
    }

    @DeleteMapping("/delete/train/{pnr}")
    public ResponseEntity<String> deleteTrain(@PathVariable String pnr){
        adminService.deleteTrain(pnr);
        return ResponseEntity.ok("Train deleted successfully!");
    }

    @PutMapping("/update/train/{pnr}")
    public ResponseEntity<Train> updateTrainDetails(@PathVariable String pnr, @RequestBody Train train){
        adminService.updateTrain(pnr,train);

        return ResponseEntity.ok(train);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Train>> getAllTrains(){
        return ResponseEntity.ok(adminService.getAllTrains());
    }
}
