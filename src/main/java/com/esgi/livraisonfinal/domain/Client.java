package com.esgi.livraisonfinal.domain;

public class Client {

    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    //private Map<String, String> codes; // une map avec l'id du colis et le code de validation

    public Client(String id, String nom, String prenom, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
        //this.codes = new HashMap<>();
    }

    public void recevoirCode(String idColis, String code) {
        //  this.codes.put(idColis, code);
        System.out.println("Code de livraison reçu pour le colis " + idColis + " : " + code);
    }

      /*   public String getCode(String idColis) throws ColisNotFoundException {
        if (!this.codes.containsKey(idColis)) {
            throw new ColisNotFoundException("Le colis avec l'id " + idColis + " n'a pas été trouvé pour le client " + this.id);
        }
        return this.codes.get(idColis);
    }*/





    public void noterLivraison(Colis colis, int note) {
        System.out.println("Le client " + nom + " " + prenom + " a noté la livraison du colis " + colis.getId() + " avec la note " + note);
    }

    public String getId() {
        return this.id;
    }




}