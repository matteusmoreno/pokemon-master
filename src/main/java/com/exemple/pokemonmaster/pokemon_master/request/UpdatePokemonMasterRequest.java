package com.exemple.pokemonmaster.pokemon_master.request;

import com.exemple.pokemonmaster.pokemon_master.domain.City;
import jakarta.validation.constraints.NotNull;

public record UpdatePokemonMasterRequest(
        @NotNull(message = "id is required")
        Long id,
        String name,
        City city) {
}
