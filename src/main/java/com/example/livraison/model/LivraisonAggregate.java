package com.example.livraison.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LivraisonAggregate {

    private Client client;
    private String livraisonId;
    private Colis colis;
    private Livreur livreur;
    private Sender sender;
    private Recipient recipient;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime deliveryTime;
    private List<DeliveryEvent> deliveryEvents;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public String getLivraisonId() {
        return livraisonId;
    }

    public void setLivraisonId(String livraisonId) {
        this.livraisonId = livraisonId;
    }

    public Colis getColis() {
        return colis;
    }

    public void setColis(Colis colis) {
        this.colis = colis;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    public Recipient getRecipient() {
        return recipient;
    }

    public void setRecipient(Recipient recipient) {
        this.recipient = recipient;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public List<DeliveryEvent> getDeliveryEvents() {
        return deliveryEvents;
    }

    public void setDeliveryEvents(List<DeliveryEvent> deliveryEvents) {
        this.deliveryEvents = deliveryEvents;
    }


    // contructor
    public LivraisonAggregate(String livraisonId, Client client,  Colis colis, Livreur livreur, Sender sender, Recipient recipient){
        this.livraisonId = livraisonId;
        this.colis = colis;
        this.client = client;
        this.livreur = livreur;
        this.sender = sender;
        this.recipient = recipient;
        this.deliveryStatus = DeliveryStatus.PENDING;
        this.deliveryTime = null;
        this.deliveryEvents = new ArrayList<>();
    }

    // Method for marking the colis as delivered
    public void markAsDelivered() {
        if (deliveryStatus == DeliveryStatus.PENDING) {
            deliveryStatus = DeliveryStatus.DELIVERED;
            deliveryTime = LocalDateTime.now();
            DeliveryEvent deliveryEvent = new DeliveryEvent(livraisonId, "Delivered");
            deliveryEvents.add(deliveryEvent);
        }
    }

    // Method for marking the colis as failed
    public void markAsFailed() {
        if (deliveryStatus == DeliveryStatus.PENDING) {
            deliveryStatus = DeliveryStatus.FAILED;
            deliveryTime = LocalDateTime.now();
            DeliveryEvent deliveryEvent = new DeliveryEvent(livraisonId, "Failed");
            deliveryEvents.add(deliveryEvent);
        }
    }


    // Inner class for delivery events
    private static class DeliveryEvent {
        private String livraisonId;
        private String event;
        private LocalDateTime timestamp;

        public String getLivraisonId() {
            return livraisonId;
        }

        public void setLivraisonId(String livraisonId) {
            this.livraisonId = livraisonId;
        }

        public String getEvent() {
            return event;
        }

        public void setEvent(String event) {
            this.event = event;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        // Constructor
        public DeliveryEvent(String colisId, String event) {
            this.livraisonId = colisId;
            this.event = event;
            this.timestamp = LocalDateTime.now();
        }

    }
}

