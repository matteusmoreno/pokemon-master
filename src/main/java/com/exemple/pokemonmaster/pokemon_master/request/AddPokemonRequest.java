package com.exemple.pokemonmaster.pokemon_master.request;

import jakarta.validation.constraints.NotNull;

public record AddPokemonRequest(
        @NotNull(message = "pokemonMasterId is required")
        Long pokemonMasterId,
        @NotNull(message = "pokemonId is required")
        Long pokemonId) {
}
