package com.example.livraison.infrastructure;

import java.util.List;

import com.example.livraison.domain.Colis;

public interface ColisRepository {
    void save(Colis colis);
    Colis findByTrackingNumber(int trackingNumber);
    List<Colis> findAll();
}