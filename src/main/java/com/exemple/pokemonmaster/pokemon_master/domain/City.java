package com.exemple.pokemonmaster.pokemon_master.domain;

import lombok.Getter;

@Getter
public enum City {

    PALLET("Pallet"),
    PEWTER("Pewter"),
    CERULEAN("Cerulean"),
    VERMILION("Vermilion"),
    LAVENDER("Lavender"),
    CELADON("Celadon"),
    FUCHSIA("Fuchsia"),
    SAFFRON("Saffron"),
    CINNABAR("Cinnabar"),
    VIRIDIAN("Viridian"),
    INDIGO("Indigo");

    private final String displayName;

    City(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
