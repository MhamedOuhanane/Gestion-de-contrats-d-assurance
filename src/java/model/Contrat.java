package java.model;

import java.util.Date;

public class Contrat {
    private Integer id;
    private EnumContrat typeContrat;
    private Date dateDebut;
    private Date dateFin;

    public Contrat(Integer id, EnumContrat typeContrat, Date dateDebut, Date dateFin) {
        this.id = id;
        this.typeContrat = typeContrat;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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
}
