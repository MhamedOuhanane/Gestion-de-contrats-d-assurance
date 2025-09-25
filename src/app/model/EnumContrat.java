package app.model;

public enum EnumContrat {
    MALADIE("Maladie"),
    IMMOBILIER("Immobilier"),
    AUTOMOBILE("Automobile");

    private String description;

    EnumContrat(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
