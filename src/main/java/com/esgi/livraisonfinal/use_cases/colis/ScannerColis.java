package com.esgi.livraisonfinal.use_cases.colis;

import com.esgi.livraisonfinal.domain.LivraisonAggregate;
import com.esgi.livraisonfinal.infrastructure.LivraisonRepository;

public class ScannerColis {
    private LivraisonRepository livraisonRepository;

    public ScannerColis(LivraisonRepository livraisonRepository) {
        this.livraisonRepository = livraisonRepository;
    }
    public void scannerColis(LivraisonAggregate livraisonAggregate) {
        livraisonRepository.save(livraisonAggregate); // Ajout du colis à la liste des colis à livrer dans le repository
    }
}
