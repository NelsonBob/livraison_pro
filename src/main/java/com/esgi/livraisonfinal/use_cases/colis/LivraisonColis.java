package com.esgi.livraisonfinal.use_cases.colis;


import com.esgi.livraisonfinal.domain.Client;
import com.esgi.livraisonfinal.domain.Colis;
import com.esgi.livraisonfinal.domain.LivraisonAggregate;
import com.esgi.livraisonfinal.domain.Livreur;
import com.esgi.livraisonfinal.infrastructure.ClientRepository;
import com.esgi.livraisonfinal.infrastructure.ColisRepository;
import com.esgi.livraisonfinal.infrastructure.LivraisonRepository;
import com.esgi.livraisonfinal.use_cases.exeption.ClientNotFoundException;
import com.esgi.livraisonfinal.use_cases.exeption.ColisAlreadyDeliveredException;
import com.esgi.livraisonfinal.use_cases.exeption.ColisNotFoundException;

import java.util.List;

import static com.esgi.livraisonfinal.domain.DeliveryStatus.DELIVERED;
import static com.esgi.livraisonfinal.domain.DeliveryStatus.PENDING;

public class LivraisonColis {

    //le Livreur scan les colis
    // les colis sont ajouter a la liste des colis livre de la journee
    // les code sont envoyer a des clients
    // le livreur  verifi le code
    // le colis est livré au client
    // le client effectue une notation


    private LivraisonRepository livraisonRepository;
    private ClientRepository clientRepository;
    private ScannerColis scannerColis;
    private ColisRepository colisRepository;

    public LivraisonColis(LivraisonRepository livraisonRepository, ClientRepository clientRepository, ScannerColis scannerColis, ColisRepository colisRepository) {
        this.livraisonRepository = livraisonRepository;
        this.clientRepository = clientRepository;
        this.scannerColis = scannerColis;
        this.colisRepository = colisRepository;
    }

    public List<Colis> livrerColis(Livreur livreur, List<LivraisonAggregate> listLivraisonAggregate) throws ColisNotFoundException, ClientNotFoundException, ColisAlreadyDeliveredException, ClientNotFoundException {


        // Le livreur scanner les colis et les ajoute à la liste de livraison de la journée
        ColisRepository colisRepository = new ColisRepository();
        for (LivraisonAggregate livraisonAggregate : listLivraisonAggregate) {
            scannerColis.scannerColis(livraisonAggregate);
            livraisonRepository.save(livraisonAggregate);
        }

        List<Colis> colisScannes = colisRepository.getColisALivrer();

        // Les codes des colis sont envoyés au client

        for (Colis colis : colisScannes) {
            String clientId = colis.getClientId();
            Client client = clientRepository.getClientById(clientId);
            client.recevoirCode(colis.getId(),colis.getCode());
        }

        // Le livreur vérifie le code et livre les colis, puis envoie une notification au client
        for (Colis colis : colisScannes) {
            Client client = clientRepository.getClientById(colis.getClientId());

            livrerColis(livraisonRepository.findById(colis.getId()), client);
        }

        return colisRepository.getColisLivre();
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


    }

}