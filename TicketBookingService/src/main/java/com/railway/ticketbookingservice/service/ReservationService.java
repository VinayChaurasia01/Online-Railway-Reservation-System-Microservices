package com.railway.ticketbookingservice.service;

import com.railway.ticketbookingservice.client.TrainInformationClient;
import com.railway.ticketbookingservice.model.Reservation;
import com.railway.ticketbookingservice.repo.ReservationRepository;
import com.railway.traininformationservice.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private TrainInformationClient trainInformationClient;


    Train train = new Train();

    public Reservation createReservation(String pnr ,Reservation reservation){

        train = trainInformationClient.getTrainByPnr(pnr);

        reservation.setSource(train.getSource());
        reservation.setDestination(train.getDestination());
        reservation.setSchedule(train.getSchedule());
        reservation.setPrice(train.getPrice());
        reservation.setPnrNumber(pnr);


        reservationRepository.save(reservation);
        return reservation;
    }

    public Reservation cancelReservation(Long passengerId){
        Reservation reservation = reservationRepository.findByPassengerId(passengerId);

        if(reservation != null){
            reservationRepository.delete(reservation);
            return reservation;
        }
        return null;
    }

    public Reservation showReservationDetails(Long passengerId){
        Reservation reservation = reservationRepository.findByPassengerId(passengerId);

        if(reservation != null){
            return reservation;
        }
        return null;
    }

    public double getAmount(String pnr){
        Train train = trainInformationClient.getTrainByPnr(pnr);
        return train.getPrice();
    }
}
