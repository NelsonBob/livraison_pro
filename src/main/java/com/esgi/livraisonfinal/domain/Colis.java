package com.esgi.livraisonfinal.domain;

import java.util.UUID;

public class Colis {

    private String id;
    private double weight;
    private String code;
    private String idClient;

    public void setId(String id) {
        this.id = id;
    }


    public String getClientId() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }


    public Colis(String id, double weight, String idClient) {
        this.id = id;
        this.weight = weight;
        this.idClient = idClient;
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


}

