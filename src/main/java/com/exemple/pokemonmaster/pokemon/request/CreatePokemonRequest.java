package com.exemple.pokemonmaster.pokemon.request;

import com.exemple.pokemonmaster.pokemon.domain.PokemonType;
import jakarta.validation.constraints.NotNull;

public record CreatePokemonRequest(
        @NotNull(message = "Name is required")
        String name,
        @NotNull(message = "Type is required")
        PokemonType type,
        @NotNull(message = "Image is required")
        String image,
        @NotNull(message = "Description is required")
        String description) {
}
