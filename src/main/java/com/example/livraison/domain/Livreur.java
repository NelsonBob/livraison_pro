package com.example.livraison.domain;

import java.util.List;
import java.util.UUID;

import com.example.livraison.use_case.exeption.ColisAlreadyDeliveredException;
import com.example.livraison.use_case.exeption.ColisNotFoundException;
import com.example.livraison.use_case.repository.ColisRepository;

public class Livreur {

    private ColisRepository colisRepository;

    public Livreur(ColisRepository colisRepository) {
        this.colisRepository = colisRepository;
    }

    public void scannerColis(Colis colis) {
        colisRepository.saveColis(colis); // Ajout du colis à la liste des colis à livrer dans le repository
    }

    public void livrerColis(Colis colis, Client client) throws ColisNotFoundException, ColisAlreadyDeliveredException {

        boolean colisEstALivrer = colisRepository.getColisALivrer().contains(colis);

        if (colisEstALivrer == false) {
            throw new ColisNotFoundException("Le colis n'existe pas dans les colis à livrer");
        }

        if(colis.getDelivered()){
            throw new ColisAlreadyDeliveredException("Le colis a déjà été livré");
        }

        colis.setDelivered(); // Colis passé en livré
        colisRepository.setDelivered(colis); // Suppression du colis de la liste des colis à livrer dans le repository
        client.envoyerNotificationNoterLivraison(colis); // Demande au client de noter la livraison
    }

    public List<Colis> getColisALivrer() {
        return colisRepository.getColisALivrer(); // Récupération de la liste des colis à livrer depuis le repository
    }

    public List<Colis> getColisLivre() {
        return colisRepository.getColisLivre(); // Récupération de la liste des colis livrés depuis le repository
    }
}
