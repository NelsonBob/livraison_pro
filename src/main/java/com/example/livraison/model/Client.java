package com.example.livraison.model;

public class Client {

        private String id;
        private String nom;
        private String prenom;


        public Client(String id, String nom, String prenom) {
            this.id = id;
            this.nom = nom;
            this.prenom = prenom;
        }

         public void recevoirCode(String idColis, String code) {
            System.out.println("Code de livraison reçu pour le colis " + idColis + " : " + code);
        }


    public void envoyerNotificationNoterLivraison(LivraisonAggregate livraisonAggregate) {
        System.out.println("Notification envoyée à " + nom + " " + prenom + " pour noter la livraison du colis " + livraisonAggregate.getLivraisonId());
    }



    public void noterLivraison(Colis colis, int note) {
        System.out.println("Le client " + nom + " " + prenom + " a noté la livraison du colis " + colis.getId() + " avec la note " + note);
    }

    public String getId() {
        return this.id;
    }




}
