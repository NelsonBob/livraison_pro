package com.example.livraison.use_case.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.livraison.model.Colis;

public class ColisRepository {

    private List<Colis> colisALivrer = new ArrayList<>();
    private List<Colis> colisLivre = new ArrayList<>();

    public void saveColis(Colis colis) {
        colisALivrer.add(colis);
    }

    public void setDelivered(Colis colis) {
        colisALivrer.remove(colis);
        colisLivre.add(colis);
    }


    public List<Colis> getColisALivrer() {
        return colisALivrer;
    }

    public List<Colis> getColisLivre() {
        return colisLivre;
    }

    public String getCodeByColisAndClientId(String colisId, String clientId) {
        for (Colis colis : colisALivrer) {
            if (colis.getId().equals(colisId) && colis.getIdClient().equals(clientId)) {
                return colis.getCodeVerification();
            }
        }
        return null;
    }
}
