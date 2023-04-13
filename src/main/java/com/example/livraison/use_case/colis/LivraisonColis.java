package com.example.livraison.use_case.colis;

import java.util.ArrayList;
import java.util.List;

import com.example.livraison.use_case.domain.Client;
import com.example.livraison.use_case.domain.Colis;
import com.example.livraison.use_case.domain.Livreur;
import com.example.livraison.use_case.exeption.ClientNotFoundException;
import com.example.livraison.use_case.exeption.ColisNotFoundException;
import com.example.livraison.use_case.repository.ClientRepository;
import com.example.livraison.use_case.repository.ColisRepository;

public class LivraisonColis {

    //le Livreur scan les colis
    // les colis sont ajouter a la liste des colis livre de la journee
    // les code sont envoyer a des clients
    // le livreur  verifi le code
    // le colis est livré au client
    // le client effectue une notation


    public void livrerColis(Livreur livreur, List<Colis> listColis) throws ColisNotFoundException, ClientNotFoundException {


        // Le livreur scanner les colis et les ajoute à la liste de livraison de la journée
        ColisRepository colisRepository = new ColisRepository();
        for (Colis colis : listColis) {
            livreur.scannerColis(colis);
            colisRepository.saveColis(colis);
        }

        List<Colis> colisScannes = colisRepository.getColisALivrer();
    
        // Les codes des colis sont envoyés au client
        for (Colis colis : colisScannes) {
            String clientId = colis.getClientId();
            Client client = ClientRepository.getClientById(clientId);
            client.recevoirCode(colis.getId(),colis.getCode());
        }
    
        // Le livreur vérifie le code et livre les colis, puis envoie une notification au client
        for (Colis colis : colisScannes) {
            Client client = ClientRepository.getClientById(colis.getClientId());
            String codeValidationClient = client.getCode(colis.getId());
            if (codeValidationClient.equals(colis.getCode())) {
                livreur.livrerColis(colis, client);
            }
        }
    }
    


}

