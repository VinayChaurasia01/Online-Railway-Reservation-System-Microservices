package com.railway.ticketbookingservice.dto;

import jakarta.validation.constraints.*;

public class ReservationDTO {

    @NotBlank(message = "Passenger name is required")
    private String passengerName;

    @Min(value = 18, message = "Passenger age must be at least 18")
    private int passengerAge;

    @NotNull(message = "Passenger ID is required")
    private Long passengerId;

    @NotBlank(message = "Source is required")
    private String source;

    @NotBlank(message = "Destination is required")
    private String destination;

    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private double price;

    @NotBlank(message = "PNR number is required")
    private String pnrNumber;

    @NotBlank(message = "Schedule is required")
    private String schedule;

    @NotBlank(message = "Booking date is required")
    private String bookingDate;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    // Getters and Setters

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(String pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

