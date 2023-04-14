package com.esgi.livraisonfinal.infrastructure;

import com.esgi.livraisonfinal.domain.LivraisonAggregate;

import java.util.List;

public interface LivraisonRepository {
    void save(LivraisonAggregate livraisonAggregate);
    void delete(LivraisonAggregate livraisonAggregate);
    LivraisonAggregate findById(String livraisonId);
    List<LivraisonAggregate> findBySender(String sender);
    List<LivraisonAggregate> findByRecipient(String recipient);
    List<LivraisonAggregate> findByStatus(LivraisonAggregate status);
}
