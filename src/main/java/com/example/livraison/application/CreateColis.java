package com.example.livraison.application;


import com.example.livraison.domain.Colis;
import com.example.livraison.infrastructure.ColisRepository;

public class CreateColis {
    private final ColisRepository colisRepository;

    public CreateColis(ColisRepository colisRepository) {
        this.colisRepository = colisRepository;
    }

    public void execute(String originAddress, String destinationAddress, double weight) {
        int trackingNumber = generateTrackingNumber();
        Colis colis = new Colis(originAddress, destinationAddress, weight, trackingNumber);
        colisRepository.save(colis);
    }

    private int generateTrackingNumber() {
        return 0;
    }
}