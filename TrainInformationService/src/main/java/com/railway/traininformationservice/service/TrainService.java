package com.railway.traininformationservice.service;


import com.railway.traininformationservice.model.Train;
import com.railway.traininformationservice.repo.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    public Train getTrainByPnr(String pnr) {
        return trainRepository.findByPnr(pnr);
    }

    public Train addTrain(Train train) {
        return trainRepository.save(train);
    }

    public Train updateTrain(String pnr, Train trainDetails) {
        Train train = trainRepository.findById(pnr).orElseThrow(() -> new RuntimeException("Train not found!"));
        train.setName(trainDetails.getName());
        train.setSource(trainDetails.getSource());
        train.setDestination(trainDetails.getDestination());
        train.setSchedule(trainDetails.getSchedule());
        train.setTrainType(trainDetails.getTrainType());
        train.setSeatCapacity(trainDetails.getSeatCapacity());
        train.setPrice(trainDetails.getPrice());
        return trainRepository.save(train);
    }

    public void deleteTrain(String pnr) {
        trainRepository.deleteById(pnr);
    }

    // New method to search trains by name
    public List<Train> searchTrainsByName(String name) {
        return trainRepository.findByNameContaining(name);
    }

    // New method to search trains by source and destination
    public List<Train> searchTrainsByRoute(String source, String destination) {
        return trainRepository.findBySourceAndDestination(source, destination);
    }
}
