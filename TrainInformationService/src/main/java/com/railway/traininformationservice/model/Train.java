package com.railway.traininformationservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trains")
public class Train {
    @Id
    @Column(nullable = false, unique = true)
    private String pnr; // PNR number as the unique identifier

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int seatCapacity;

    @Column(nullable = false)
    public double getPrice() {
        return price;
    }

    @Column(nullable = false)
    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Column(nullable = false)
    public double price;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getName() {
        return name;
    }

    public String getPnr() {
        return pnr;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private String schedule;

    @Column(nullable = false)
    private String trainType;
}
