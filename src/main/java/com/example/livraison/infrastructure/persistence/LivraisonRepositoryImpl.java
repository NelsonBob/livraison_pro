package com.example.livraison.infrastructure.persistence;

import com.example.livraison.model.LivraisonAggregate;
import com.example.livraison.model.repository.LivraisonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LivraisonRepositoryImpl implements LivraisonRepository {
    private Map<String, LivraisonRepository> livraisonMap = new HashMap<>();

    public void save(LivraisonAggregate livraison) {
        livraisonMap.put(livraison.getLivraisonId(), (LivraisonRepository) livraison);
    }

    @Override
    public void delete(LivraisonAggregate livraisonAggregate) {

    }

    @Override
    public LivraisonAggregate findById(String livraisonId) {
        return (LivraisonAggregate) livraisonMap.get(livraisonId);
    }

    @Override
    public List<LivraisonAggregate> findBySender(String sender) {
        return (List<LivraisonAggregate>) livraisonMap.values().stream();

    }

    @Override
    public List<LivraisonAggregate> findByRecipient(String recipient) {
        return null;
    }

    @Override
    public List<LivraisonAggregate> findByStatus(LivraisonAggregate status) {
        return null;
    }
}
