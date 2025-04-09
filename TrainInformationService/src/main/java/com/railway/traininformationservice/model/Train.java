package com.railway.traininformationservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "trains")
@Getter
@Setter
public class Train {
    @Id
    @Column(nullable = false, unique = true)
    private String pnr; // PNR number as the unique identifier

    @NotNull
    private String name;

    @NotNull
    public double getPrice() {
        return price;
    }

    public void setPrice(@NotNull double price) {
        this.price = price;
    }

    @NotNull
    public double price;

    public @NotNull String getSource() {
        return source;
    }

    public void setSource(@NotNull String source) {
        this.source = source;
    }

    public @NotNull String getName() {
        return name;
    }

    public String getPnr() {
        return pnr;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getDestination() {
        return destination;
    }

    public void setDestination(@NotNull String destination) {
        this.destination = destination;
    }

    public @NotNull String getSchedule() {
        return schedule;
    }

    public void setSchedule(@NotNull String schedule) {
        this.schedule = schedule;
    }

    public @NotNull String getTrainType() {
        return trainType;
    }

    public void setTrainType(@NotNull String trainType) {
        this.trainType = trainType;
    }

    @NotNull
    private String source;

    @NotNull
    private String destination;

    @NotNull
    private String schedule; // e.g., "10:00 AM - 2:00 PM"

    @NotNull
    private String trainType; // e.g., "Express", "Local"
}
