package com.gloflox.model;

import java.time.LocalDate;

public class BookingRequest {
    private String name;
    private LocalDate date;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
