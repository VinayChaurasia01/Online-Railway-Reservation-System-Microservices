package com.railway.adminservice.service;

import com.netflix.discovery.converters.Auto;
import com.railway.adminservice.client.TrainInfoClient;
import com.railway.traininformationservice.model.Train;
import com.railway.traininformationservice.repo.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private TrainInfoClient trainInfoClient;

    public Train addTrain(Train train){
        trainInfoClient.addTrain(train);
        return train;
    }

    public String deleteTrain(String pnr){
        trainInfoClient.deleteTrain(pnr);
        return "train deleted successfully!";
    }

    public Train updateTrain(String pnr,Train train){
        trainInfoClient.updateTrain(pnr,train);
        return train;
    }

    public List<Train> getAllTrains(){
        List<Train> trains = trainInfoClient.getAllTrains();
        return trains;
    }

}
