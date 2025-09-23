package java.model;

public class Client extends Person {
    private Integer conseiller_id;

    public Client(Integer id, String nom, String prenom, String email, Integer conseiller_id) {
        super(id, nom, prenom, email);
        this.conseiller_id = conseiller_id;
    }

    public void setConseiller_id(Integer conseiller_id) {
        this.conseiller_id = conseiller_id;
    }

    public Integer getConseiller_id() {
        return conseiller_id;
    }
}
