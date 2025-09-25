package app.model;

import java.time.LocalDateTime;

public class Sinistre {
    private Integer id;
    private EnumSinistre typeSinistre;
    private LocalDateTime date;
    private Double montant;
    private String description;
    private Integer contrat_id;

    public Sinistre(Integer id, EnumSinistre typeSinistre, LocalDateTime date, Double montant, String description, Integer contrat_id) {
        this.id = id;
        this.typeSinistre = typeSinistre;
        this.date = date;
        this.montant = montant;
        this.description = description;
        this.contrat_id = contrat_id;
    }

    public Sinistre(EnumSinistre typeSinistre, LocalDateTime date, Double montant, String description, Integer contrat_id) {
        this.typeSinistre = typeSinistre;
        this.date = date;
        this.montant = montant;
        this.description = description;
        this.contrat_id = contrat_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTypeSinistre(EnumSinistre typeSinistre) {
        this.typeSinistre = typeSinistre;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContrat_id(Integer contrat_id) {
        this.contrat_id = contrat_id;
    }

    public Integer getId() {
        return id;
    }

    public EnumSinistre getTypeSinistre() {
        return typeSinistre;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Double getMontant() {
        return montant;
    }

    public String getDescription() {
        return description;
    }

    public Integer getContrat_id() {
        return contrat_id;
    }
}
