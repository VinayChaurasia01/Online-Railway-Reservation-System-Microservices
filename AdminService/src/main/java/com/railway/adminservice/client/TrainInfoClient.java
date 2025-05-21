package com.railway.adminservice.client;

import com.railway.traininformationservice.model.Train;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "TRAININFORMATIONSERVICE",configuration = TrainInfoClientConfig.class)
public interface TrainInfoClient {

    @PostMapping("/trains/add")
    Train addTrain(@RequestBody Train train);

    @DeleteMapping("/trains/delete/{pnr}")
    ResponseEntity<Void> deleteTrain(@PathVariable String pnr);

    @PutMapping("/trains/update/{pnr}")
    ResponseEntity<Train> updateTrain(@PathVariable String pnr, @RequestBody Train train);

    @GetMapping("/trains/all")
    List<Train> getAllTrains();

}
