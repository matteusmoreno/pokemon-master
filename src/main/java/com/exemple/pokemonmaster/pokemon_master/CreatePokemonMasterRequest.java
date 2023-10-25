package com.exemple.pokemonmaster.pokemon_master;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePokemonMasterRequest(
        @NotBlank
        String name,
        @NotNull
        City city) {
}
