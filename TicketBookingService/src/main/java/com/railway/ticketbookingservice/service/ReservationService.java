package com.railway.ticketbookingservice.service;


import com.railway.notificationservice.model.NotificationRequest;
import com.railway.ticketbookingservice.client.NotificationClient;
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

    @Autowired
    private NotificationClient notificationClient;


    Train train = new Train();

    NotificationRequest notification = new NotificationRequest();

    public Reservation createReservation(String pnr ,Reservation reservation){

        train = trainInformationClient.getTrainByPnr(pnr);

        reservation.setSource(train.getSource());
        reservation.setDestination(train.getDestination());
        reservation.setSchedule(train.getSchedule());
        reservation.setPrice(train.getPrice());
        reservation.setPnrNumber(pnr);


        reservationRepository.save(reservation);

        notification.setEmail(reservation.getEmail());
        notification.setPassengerName(reservation.getPassengerName());
        notification.setPnrNumber(reservation.getPnrNumber());
        notification.setAge(reservation.getPassengerAge());
        notification.setPassengerId(reservation.getPassengerId());

        notificationClient.sendBookingConfirmation(notification);

        return reservation;
    }

    public Reservation cancelReservation(Long passengerId){
        Reservation reservation = reservationRepository.findByPassengerId(passengerId);

        if(reservation != null){
            reservationRepository.delete(reservation);

            notification.setEmail(reservation.getEmail());
            notification.setPassengerName(reservation.getPassengerName());
            notification.setPnrNumber(reservation.getPnrNumber());
            notification.setAge(reservation.getPassengerAge());
            notification.setPassengerId(reservation.getPassengerId());

            notificationClient.sendCancellationConfirmation(notification);
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

    public Long isAvailable(String pnr) {
        // Fetch train details using PNR
        train = trainInformationClient.getTrainByPnr(pnr);

        // Count the number of reservations for the given PNR
        long bookedSeats = reservationRepository.countByPnrNumber(pnr);

        boolean isAvailable = bookedSeats < train.getSeatCapacity();

        if(!isAvailable){
            throw new RuntimeException("Seats not available!");
        }
        return (train.getSeatCapacity()-bookedSeats);
    }

    public long getBookingCountForDay(String bookingDate) {
        // Count reservations for the given booking date
        return reservationRepository.countByBookingDate(bookingDate);
    }
}
