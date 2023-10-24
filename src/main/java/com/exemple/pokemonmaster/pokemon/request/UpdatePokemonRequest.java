package com.exemple.pokemonmaster.pokemon.request;

import com.exemple.pokemonmaster.pokemon.domain.PokemonType;
import jakarta.validation.constraints.NotNull;

public record UpdatePokemonRequest(
        @NotNull(message = "Id is required")
        Long id,
        String name,
        PokemonType type,
        String image,
        String description) {
}
