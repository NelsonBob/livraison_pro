package com.example.livraison.use_case.domain;

public class Colis {
    private String id;
    private String originAddress;
    private String destinationAddress;
    private double weight;
    private String code;
    
    public Colis(String id, String originAddress, String destinationAddress, double weight) {
        this.id = id;
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.weight = weight;
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

}