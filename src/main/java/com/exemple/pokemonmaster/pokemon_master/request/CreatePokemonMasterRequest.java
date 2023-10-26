package com.exemple.pokemonmaster.pokemon_master.request;

import com.exemple.pokemonmaster.pokemon_master.domain.City;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePokemonMasterRequest(
        @NotBlank
        String name,
        @NotNull
        City city) {
}
