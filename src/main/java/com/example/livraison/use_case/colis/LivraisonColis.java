package com.example.livraison.use_case.colis;

import java.util.ArrayList;
import java.util.List;

import com.example.livraison.use_case.domain.Client;
import com.example.livraison.use_case.domain.Colis;

public class LivraisonColis {

    //le Livreur scan les colis
    // les colis sont ajouter a la liste des colis livre de la journee
    // les code sont envoyer a des clients
    // le livreur  verifi le code
    // le colis est livré au client
    // le client effectue une notation


    private List<Colis> colisLivre = new ArrayList<Colis>();

    public void ajouterColisLivre(Colis colis) {
        colisLivre.add(colis);
    }

    public void envoyerCodeClient(Colis colis, Client client) {
        String code = colis.getCode();
        client.recevoirCode(code);
    }

    public boolean verifierCode(Colis colis, String code) {
        return colis.getCode().equals(code);
    }

    public void livrerColis(Colis colis, Client client) {
        if (verifierCode(colis, client.getCode())) {
            colisLivre.add(colis);
            client.noterLivraison(colis);
        }
    }

}

