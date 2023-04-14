package com.example.livraison.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Colis {
    private String id;
    private String destinataire;
    private String adresseLivraison;
    private String codeVerification;
    private StatutLivraison statutLivraison;
    private String idClient;
    private LocalDate dateCreation;
    private LocalDate dateLivraisonEstimee;
    private Livreur livreur;
    private List<EtapeLivraison> etapesLivraison;

    public Colis(String destinataire, String adresseLivraison, String idClient, LocalDate dateLivraisonEstimee) {
        this.id = UUID.randomUUID().toString();
        this.destinataire = destinataire;
        this.adresseLivraison = adresseLivraison;
        this.codeVerification = UUID.randomUUID().toString();
        this.statutLivraison = StatutLivraison.EN_ATTENTE;
        this.idClient = idClient;
        this.dateCreation = LocalDate.now();
        this.dateLivraisonEstimee = dateLivraisonEstimee;
        List<EtapeLivraison> etapesLivraison = new ArrayList<>();
        etapesLivraison.add(new EtapeLivraison("Le colis a été créé", this.dateCreation));

        this.livreur = null;    }

    public String getId() {
        return id;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public void setDestinataire(String destinataire) {
        this.destinataire = destinataire;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public String getCodeVerification() {
        return codeVerification;
    }

    public StatutLivraison getStatutLivraison() {
        return statutLivraison;
    }

    public String getIdClient() {
        return idClient;
    }

    public LocalDate getDateCreation() {
        return dateCreation;
    }

    public LocalDate getDateLivraisonEstimee() {
        return dateLivraisonEstimee;
    }

    public Livreur getLivreur() {
        return livreur;
    }

    public void setLivreur(Livreur livreur) {
        this.livreur = livreur;
    }

    public List<EtapeLivraison> getEtapesLivraison() {
        return etapesLivraison;
    }
    public void livrer(String code) throws Exception {
        if (!this.codeVerification.equals(code)) {
            throw new Exception("Le code de vérification est incorrect");
        }
        if (this.statutLivraison == StatutLivraison.LIVRE) {
            throw new Exception("Le colis a déjà été livré");
        }
        if (this.livreur == null) {
            throw new Exception("Le colis n'a pas encore été pris en charge par un livreur");
        }
        if (LocalDate.now().isAfter(this.dateLivraisonEstimee)) {
            throw new Exception("Le colis est en retard");
        }

        this.statutLivraison = StatutLivraison.LIVRE;
    }

    public void modifierAdresseLivraison(String nouvelleAdresse) throws Exception {
        if (this.statutLivraison != StatutLivraison.EN_ATTENTE) {
            throw new Exception("Le colis a déjà été pris en charge et ne peut plus être modifié");
        }

        etapesLivraison.add(new EtapeLivraison("L'adresse a été modifiée", LocalDate.now()));

        this.adresseLivraison = nouvelleAdresse;
    }


}