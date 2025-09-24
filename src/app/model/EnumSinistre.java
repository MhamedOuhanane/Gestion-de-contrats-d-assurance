package app.model;

public enum EnumSinistre {
    MALADIE("maladie"),
    MAISON("accident de maison"),
    VOITURE("accident de voiture");

    private final String description;

    EnumSinistre(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
