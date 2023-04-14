package com.example.livraison.model;

import java.util.List;

import com.example.livraison.model.repository.LivraisonRepository;
import com.example.livraison.use_case.exeption.ColisAlreadyDeliveredException;
import com.example.livraison.use_case.exeption.ColisNotFoundException;
import com.example.livraison.model.repository.ColisRepository;

import static com.example.livraison.model.DeliveryStatus.DELIVERED;
import static com.example.livraison.model.DeliveryStatus.PENDING;

public class Livreur {

    private LivraisonRepository livraisonRepository;

    public Livreur(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }

    public void scannerColis(LivraisonAggregate livraisonAggregate) {
        livraisonRepository.save(livraisonAggregate); // Ajout du colis à la liste des colis à livrer dans le repository
    }

    public void livrerColis(LivraisonAggregate livraisonAggregate, Client client) throws ColisNotFoundException, ColisAlreadyDeliveredException {

        LivraisonAggregate colisExist = livraisonRepository.findById(livraisonAggregate.getLivraisonId());

        // can not find colis
        if (colisExist == null) {
            throw new ColisNotFoundException("Le colis n'existe pas dans les colis à livrer");
        }

        // colis already delivered
        if(livraisonAggregate.getDeliveryStatus() == DELIVERED){
            throw new ColisAlreadyDeliveredException("Le colis a déjà été livré");
        }

        // colis go to deliver
        livraisonAggregate.setDeliveryStatus(PENDING); // Colis passé en livré

        client.envoyerNotificationNoterLivraison(livraisonAggregate); // Demande au client de noter la livraison
    }

}
