package com.example.livraison.use_case.repository;

import com.example.livraison.model.LivraisonAggregate;

import java.util.List;

public interface LivraisonRepository {
    // Persists a new or updated livraison
    void save(LivraisonAggregate order);

    // Deletes a livraison
    void delete(LivraisonAggregate order);

    // Retrieves a livraison by ID
    LivraisonAggregate findById(String orderId);

    // Retrieves livraisons by client ID
    List<LivraisonAggregate> findByClient(String clientId);

    // Retrieves livraisons by status
    List<LivraisonAggregate> findByStatus(LivraisonAggregate status);

}
