package com.example.suivez_inr.models;

public class patient {
    private int identifiant;
    private String name;
    private double val_INR;
    private String ATCD;
    private String Diagnostic;
    private String traitement;

    public patient(int identifiant, String name, double val_INR, String ATCD, String diagnostic, String traitement) {
        this.identifiant = identifiant;
        this.name = name;
        this.val_INR = val_INR;
        this.ATCD = ATCD;
        Diagnostic = diagnostic;
        this.traitement = traitement;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVal_INR() {
        return val_INR;
    }

    public void setVal_INR(double val_INR) {
        this.val_INR = val_INR;
    }

    public String getATCD() {
        return ATCD;
    }

    public void setATCD(String ATCD) {
        this.ATCD = ATCD;
    }

    public String getDiagnostic() {
        return Diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        Diagnostic = diagnostic;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }
}
