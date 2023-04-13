package com.example.livraison.domain;

import java.util.UUID;

public class Colis {
    private String id;
    private String originAddress;
    private String destinationAddress;
    private double weight;
    private String code;
    private String clientId;
    private boolean isDelivered;
    
    public Colis(String id, String originAddress, String destinationAddress, double weight, String clientId) {
        this.id = id;
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.weight = weight;
        this.clientId = clientId;
        this.isDelivered = false;
        String codeValidation = UUID.randomUUID().toString(); // Génération d'un code de validation unique
        this.code = codeValidation; // Affectation du code de validation au colis scanné

    }
    
    public String getOriginAddress() {
        return originAddress;
    }
    
    public void setOriginAddress(String originAddress) {
        this.originAddress = originAddress;
    }
    
    public String getDestinationAddress() {
        return destinationAddress;
    }
    
    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
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


    public String getClientId() {
        return this.clientId;
    }

    public void setDelivered() {
        this.isDelivered = true;
    }

    public boolean getDelivered() {
        return this.isDelivered;
    }

}