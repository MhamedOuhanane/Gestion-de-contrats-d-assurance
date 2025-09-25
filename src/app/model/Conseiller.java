package app.model;

public class Conseiller extends Person {
    public Conseiller(Integer id ,String nom, String prenom, String email) {
        super(id, nom, prenom, email);
    }
    public Conseiller(String nom, String prenom, String email) {
        super(nom, prenom, email);
    }

}
