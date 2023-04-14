package com.example.livraison.model;

public class LivraisonAggregate {
    private Client client;
    private Colis colis;
    private Livreur livreur;
    private Sender sender;
    private Recipient recipient;

    // contructor
    public LivraisonAggregate(Client client, Colis colis, Livreur livreur, Sender sender, Recipient recipient){
        this.client = client;
        this.colis = colis;
        this.livreur = livreur;
        this.sender = sender;
        this.recipient = recipient;
    }

    // Update livraison status true
    public void updateLivraisonStatusTrue(Colis colis) {
        colis.setDelivered();
    }
}
