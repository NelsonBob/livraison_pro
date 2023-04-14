package com.esgi.livraisonfinal.infrastructure;

import com.esgi.livraisonfinal.domain.Colis;

import java.util.ArrayList;
import java.util.List;

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