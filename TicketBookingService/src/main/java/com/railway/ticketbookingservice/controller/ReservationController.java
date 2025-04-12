package com.railway.ticketbookingservice.controller;

import com.railway.ticketbookingservice.model.Reservation;
import com.railway.ticketbookingservice.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reservation/{pnrNumber}")
    public ResponseEntity<Reservation> bookTicket(@PathVariable String pnrNumber, @RequestBody Reservation reservation){
        reservationService.createReservation(pnrNumber,reservation);
        return ResponseEntity.ok(reservation);
    }

    @DeleteMapping("/cancel/{passengerId}")
    public ResponseEntity<Reservation> cancelTicket(@PathVariable Long passengerId){

        Reservation reservation = reservationService.cancelReservation(passengerId);
        return ResponseEntity.ok(reservation);
    }

    @GetMapping("/passenger/{passengerId}")
    public ResponseEntity<Reservation> showDetails(@PathVariable Long passengerId){
        return ResponseEntity.ok(reservationService.showReservationDetails(passengerId));
    }

    @GetMapping("/amount/{pnr}")
    public double getTicketAmount(@PathVariable String pnr){
        return reservationService.getAmount(pnr);
    }

    @GetMapping("/isAvailable/{pnrNumber}")
    public ResponseEntity<Long> checkAvailability(@PathVariable String pnrNumber) {
        long available = reservationService.isAvailable(pnrNumber);
        return ResponseEntity.ok(available);
    }

    @GetMapping("/bookingCount/{bookingDate}")
    public ResponseEntity<Long> getBookingCount(@PathVariable String bookingDate) {
        long bookingCount = reservationService.getBookingCountForDay(bookingDate);
        return ResponseEntity.ok(bookingCount);
    }
}
