package com.adesso.tireManagement.model;

/**
 * Available tire design types.
 */
public enum TireDesignType {
    RADIAL("R"),
    DIAGONAL("D"),
    STRAPPED("B");

    /**
     * The string represantation of the TireDesignType
     */
    private String value;

    /**
     * Initialize a new TireDesignType with the design type as string representation.
     * @param designTypeString
     */
    TireDesignType(String designTypeString) {
        this.value = designTypeString;
    }
}