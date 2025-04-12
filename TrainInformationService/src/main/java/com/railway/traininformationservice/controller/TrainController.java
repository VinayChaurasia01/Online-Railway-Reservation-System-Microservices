package com.railway.traininformationservice.controller;


import com.railway.traininformationservice.model.Train;
import com.railway.traininformationservice.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/all")
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }

    @GetMapping("/search/{pnr}")
    public ResponseEntity<Train> getTrainByPnr(@PathVariable String pnr) {
        Train train = trainService.getTrainByPnr(pnr);

        if(train != null){
            return ResponseEntity.ok(train);
        }
        return null;
    }

    @PostMapping("/add")
    public Train addTrain(@RequestBody Train train) {
        return trainService.addTrain(train);
    }

    @PutMapping("/update/{pnr}")
    public ResponseEntity<Train> updateTrain(@PathVariable String pnr, @RequestBody Train trainDetails) {
        Train updatedTrain = trainService.updateTrain(pnr, trainDetails);
        return ResponseEntity.ok(updatedTrain);
    }

    @DeleteMapping("/delete/{pnr}")
    public ResponseEntity<Void> deleteTrain(@PathVariable String pnr) {
        trainService.deleteTrain(pnr);
        return ResponseEntity.noContent().build();
    }

    // New endpoint to search trains by name
    @GetMapping("/search/name/{name}")
    public List<Train> searchTrainsByName(@PathVariable String name) {
        return trainService.searchTrainsByName(name);
    }

    // New endpoint to search trains by source and destination
    @GetMapping("/search/route")
    public List<Train> searchTrainsByRoute(@RequestParam String source, @RequestParam String destination) {
        return trainService.searchTrainsByRoute(source, destination);
    }
}
