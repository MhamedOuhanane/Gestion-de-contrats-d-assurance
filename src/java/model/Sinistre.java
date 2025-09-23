package java.model;

import java.time.LocalDate;
import java.util.Date;

public class Sinistre {
    private Integer id;
    private EnumSinistre typeSinistre;
    private LocalDate date;
    private Double montant;
    private String description;

    public Sinistre(Integer id, EnumSinistre typeSinistre, LocalDate date, Double montant, String description) {
        this.id = id;
        this.typeSinistre = typeSinistre;
        this.date = date;
        this.montant = montant;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTypeSinistre(EnumSinistre typeSinistre) {
        this.typeSinistre = typeSinistre;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public EnumSinistre getTypeSinistre() {
        return typeSinistre;
    }

    public LocalDate getDate() {
        return date;
    }

    public Double getMontant() {
        return montant;
    }

    public String getDescription() {
        return description;
    }
}
