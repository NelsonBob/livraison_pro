package com.example.livraison.model.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.livraison.model.Colis;
import com.example.livraison.model.LivraisonAggregate;

public class ColisRepository {

    private List<Colis> colisALivrer = new ArrayList<>();
    private List<Colis> colisLivre = new ArrayList<>();



    public List<Colis> getColisALivrer() {
        return colisALivrer;
    }

    public List<Colis> getColisLivre() {
        return colisLivre;
    }


}
