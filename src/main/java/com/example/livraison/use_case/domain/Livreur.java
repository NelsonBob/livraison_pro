package com.example.livraison.use_case.domain;

import java.util.List;
import java.util.UUID;

import com.example.livraison.use_case.exeption.ColisNotFoundException;
import com.example.livraison.use_case.repository.ColisRepository;

public class Livreur {

    private ColisRepository colisRepository;

    public Livreur(ColisRepository colisRepository) {
        this.colisRepository = colisRepository;
    }

    public String scannerColis(Colis colis) {
        String codeValidation = UUID.randomUUID().toString(); // Génération d'un code de validation unique
        colis.setCode(codeValidation); // Affectation du code de validation au colis scanné
        colisRepository.saveColis(colis); // Ajout du colis à la liste des colis à livrer dans le repository
        return codeValidation; // Retour du code de validation généré
    }

    public void livrerColis(Colis colis, Client client) throws ColisNotFoundException {
        boolean colisEstALivrer = colisRepository.getColisALivrer().contains(colis);
        if (colisEstALivrer == false) {
            throw new ColisNotFoundException("Le colis n'existe pas dans les colis à livrer");
        }
        colisRepository.setDelivered(colis); // Suppression du colis de la liste des colis à livrer dans le repository
        client.noterLivraison(colis); // Demande au client de noter la livraison
    }

    public List<Colis> getColisALivrer() {
        return colisRepository.getColisALivrer(); // Récupération de la liste des colis à livrer depuis le repository
    }

    public List<Colis> getColisLivre() {
        return colisRepository.getColisLivre(); // Récupération de la liste des colis livrés depuis le repository
    }
}
