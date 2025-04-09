package com.railway.adminservice.controller;

import com.railway.adminservice.service.AdminService;
import com.railway.traininformationservice.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/add/train")
    public Train addTrain(@RequestBody Train train){
        return adminService.addTrain(train);
    }

    @DeleteMapping("/delete/train")
    public ResponseEntity<String> deleteTrain(@PathVariable String pnr){
        adminService.deleteTrain(pnr);
        return ResponseEntity.ok("Train deleted successfully!");
    }

    @PutMapping("/update/train")
    public ResponseEntity<Train> updateTrainDetails(@PathVariable String pnr, @RequestBody Train train){
        adminService.updateTrain(pnr,train);

        return ResponseEntity.ok(train);
    }
}
