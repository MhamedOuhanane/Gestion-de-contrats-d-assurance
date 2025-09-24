package app.model;

import java.util.Date;

public class Contrat {
    private Integer id;
    private EnumContrat typeContrat;
    private Date dateDebut;
    private Date dateFin;
    private Integer client_id;

    public Contrat(Integer id, EnumContrat typeContrat, Date dateDebut, Date dateFin, Integer client_id) {
        this.id = id;
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

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public Integer getClient_id() {
        return client_id;
    }
}
