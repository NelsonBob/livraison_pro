package main.java.com.example.livraison.infrastructure;

import java.util.List;

import main.java.com.example.livraison.domain.Colis;

public interface ColisRepository {
    void save(Colis colis);
    Colis findByTrackingNumber(int trackingNumber);
    List<Colis> findAll();
}