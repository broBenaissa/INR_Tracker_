package com.example.suivez_inr.models;

import android.provider.ContactsContract;

public class Doctor {
    private int identifiant;
    private String nom;
    private String ville;
    private ContactsContract.CommonDataKinds.Phone contact;

    public Doctor(int identifiant, String nom, String ville, ContactsContract.CommonDataKinds.Phone contact) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.ville = ville;
        this.contact = contact;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public ContactsContract.CommonDataKinds.Phone getContact() {
        return contact;
    }

    public void setContact(ContactsContract.CommonDataKinds.Phone contact) {
        this.contact = contact;
    }
}
