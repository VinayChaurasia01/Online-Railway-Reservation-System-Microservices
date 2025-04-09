package com.railway.adminservice.client;

import com.railway.traininformationservice.model.Train;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "TRAININFORMATIONSERVICE")
public interface TrainInfoClient {

    @PutMapping("/trains/{pnr}")
    public ResponseEntity<Train> updateTrain(@PathVariable String pnr, @RequestBody Train trainDetails);

    @DeleteMapping("/trains/{pnr}")
    public ResponseEntity<Void> deleteTrain(@PathVariable String pnr);

    @GetMapping("/trains/search/name/{name}")
    public List<Train> searchTrainsByName(@PathVariable String name);

    @GetMapping("/trains/search/route")
    public List<Train> searchTrainsByRoute(@RequestParam String source, @RequestParam String destination);

    @PostMapping("/trains/add")
    public Train addTrain(@RequestBody Train train);

    @GetMapping
    public List<Train> getAllTrains();

    @GetMapping("/trains/search/{pnr}")
    public ResponseEntity<Train> getTrainByPnr(@PathVariable String pnr);
}
