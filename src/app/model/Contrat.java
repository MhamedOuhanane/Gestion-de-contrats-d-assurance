package app.model;


import java.time.LocalDate;

public class Contrat {
    private Integer id;
    private EnumContrat typeContrat;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Integer client_id;

    public Contrat(Integer id, EnumContrat typeContrat, LocalDate dateDebut, LocalDate dateFin, Integer client_id) {
        this.id = id;
        this.typeContrat = typeContrat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client_id = client_id;
    }

    public Contrat(EnumContrat typeContrat, LocalDate dateDebut, LocalDate dateFin, Integer client_id) {
        this.typeContrat = typeContrat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.client_id = client_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTypeContrat(EnumContrat typeContrat) {
        this.typeContrat = typeContrat;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public Integer getId() {
        return id;
    }

    public EnumContrat getTypeContrat() {
        return typeContrat;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public Integer getClient_id() {
        return client_id;
    }
}
