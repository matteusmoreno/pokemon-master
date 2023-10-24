package com.exemple.pokemonmaster;

import lombok.Getter;

@Getter
public enum PokemonType {
    NORMAL("Normal"),
    FIRE("Fogo"),
    WATER("Água"),
    GRASS("Grama"),
    ELECTRIC("Elétrico"),
    ICE("Gelo"),
    FIGHTING("Lutador"),
    POISON("Veneno"),
    GROUND("Terra"),
    FLYING("Voador"),
    PSYCHIC("Psíquico"),
    BUG("Inseto"),
    ROCK("Pedra"),
    GHOST("Fantasma"),
    STEEL("Aço"),
    DARK("Sombrio"),
    FAIRY("Fada");

    private final String displayName;

    PokemonType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
