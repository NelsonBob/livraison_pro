package com.example.livraison.use_case.colis;

import java.util.ArrayList;
import java.util.List;

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


}

