package app.model;

public class Conseiller extends Person implements AutoCloseable {
    public Conseiller(Integer id ,String nom, String prenom, String email) {
        super(id, nom, prenom, email);
    }

    @Override
    public void close() throws Exception {

    }
}
