package com.example.livraison.domain;

public class Livreur {
    private int id;
    private String name;
    private double rating;
    private boolean isAvailable;

    public Livreur(String name, int id) {
        this.id = id;
        this.name = name;
        this.rating = 5.0; // Initial rating is set to 5.0
        this.isAvailable = true; // DeliveryMan is available by default
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    //  behavior methods
    public void acceptDelivery() {
        System.out.println("DeliveryMan " + name + " has accepted the delivery.");
    }

    public void completeDelivery() {
        System.out.println("DeliveryMan " + name + " has completed the delivery.");
    }

    public void updateRating(double newRating) {
        // Update the rating by taking an average of the existing rating and the new rating
        rating = (rating + newRating) / 2;
    }
}
