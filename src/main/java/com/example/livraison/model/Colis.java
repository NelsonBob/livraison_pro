package com.example.livraison.model;

import java.util.UUID;

public class Colis {

    private String id;
    private double weight;
    private String code;
    private boolean isDelivered;

    public Colis(String id, double weight) {
        this.id = id;
        this.weight = weight;
        this.isDelivered = false;
        String codeValidation = UUID.randomUUID().toString(); // Génération d'un code de validation unique
        this.code = codeValidation; // Affectation du code de validation au colis scanné

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return this.id;
    }

    public void setDelivered() {
        this.isDelivered = true;
    }

    public boolean getDelivered() {
        return this.isDelivered;
    }

}
