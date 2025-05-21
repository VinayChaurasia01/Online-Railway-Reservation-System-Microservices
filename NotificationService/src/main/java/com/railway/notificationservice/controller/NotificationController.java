package com.railway.notificationservice.controller;


import com.railway.notificationservice.model.NotificationRequest;
import com.railway.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private EmailService emailService;



    @PostMapping("/send-booking-confirmation")
    public String sendBookingConfirmation(@RequestBody NotificationRequest request) {
        String subject = "Booking Confirmation";
        String text = "Dear " + request.getPassengerName() + ", your ticket has been successfully booked. PNR: " + request.getPnrNumber() +
                "\n Passenger details, \n Passenger name : " + request.getPassengerName() +  "\n Passenger age : " + request.getAge() +
                "\n Passenger Id (Adhar number) : " + request.getPassengerId() + "\n Thank you Booking, Happy jounery!";
        emailService.sendEmail(request.getEmail(), subject, text);
        return "Booking confirmation email sent!";
    }

    @PostMapping("/send-cancellation-confirmation")
    public String sendCancellationConfirmation(@RequestBody NotificationRequest request) {
        String subject = "Booking Cancellation";

        String text = "Dear " + request.getPassengerName() + ", your ticket with PNR: " + request.getPnrNumber() + " has been canceled."
                +"Ticket Details, \n Passenger name : " + request.getPassengerName() +  "\n Passenger age : " + request.getAge() +
        "\n Passenger Id (Adhar number) : " + request.getPassengerId() + "\n Thank you ";

        emailService.sendEmail(request.getEmail(), subject, text);
        return "Cancellation confirmation email sent!";
    }
}
