package com.example.suivez_inr.models;

public class BarEntry {

    private double date;
    private double INR_val;
    public BarEntry(double INR_val, double date) {
        this.INR_val = INR_val;
        this.date=date;
    }

    public double getINR_val() {
        return INR_val;
    }

    public double getDate() {
        return date;
    }
}
