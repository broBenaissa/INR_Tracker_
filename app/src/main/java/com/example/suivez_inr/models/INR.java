package com.example.suivez_inr.models;

import java.sql.Date;
import java.time.LocalDateTime;

public class INR {

    private LocalDateTime date;
    private double INR_val;
    public INR(double INR_val, Date date) {
        this.INR_val = INR_val;
    }

    public double getINR_val() {
        return INR_val;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
