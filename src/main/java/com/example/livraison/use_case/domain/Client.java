package com.example.livraison.use_case.domain;

public class Client {

    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String code;

    public Client(String id, String nom, String prenom, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }

    public void recevoirCode(String code) {
        this.code = code;
        System.out.println("Code de livraison reçu : " + code);
    }

    public String getCode() {
        return code;
    }

    public void noterLivraison(Colis colis) {
        // Noter la livraison en fonction de la satisfaction du client
        // Cette méthode peut être implémentée en fonction des besoins spécifiques de l'application
        System.out.println("Le client " + nom + " " + prenom + " a noté la livraison du colis " + colis.getId());
    }


}
