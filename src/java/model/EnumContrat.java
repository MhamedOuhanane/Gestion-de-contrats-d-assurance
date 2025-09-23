package java.model;

public enum EnumContrat {
    MALADIE("Maladie"),
    IMMOBILIER("Immobilier"),
    AUTOMOBILE("Automobile");

    private final String description;

    EnumContrat(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
