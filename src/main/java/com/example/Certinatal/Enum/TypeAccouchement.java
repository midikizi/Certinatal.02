package com.example.Certinatal.Enum;

public enum TypeAccouchement {
    VOIE_BASSE("Voie basse"),
    CESARIENNE("Césarienne");

    private final String label;

    TypeAccouchement(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
