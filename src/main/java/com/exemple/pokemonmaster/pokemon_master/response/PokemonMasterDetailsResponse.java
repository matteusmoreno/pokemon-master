package com.exemple.pokemonmaster.pokemon_master.response;

import com.exemple.pokemonmaster.pokemon.domain.Pokemon;
import com.exemple.pokemonmaster.pokemon_master.domain.PokemonMaster;

import java.time.LocalDateTime;
import java.util.List;

public record PokemonMasterDetailsResponse(
        Long id,
        String name,
        String city,
        List<Pokemon> pokemon,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Boolean active) {

    public PokemonMasterDetailsResponse(PokemonMaster pokemonMaster) {
        this(
                pokemonMaster.getId(),
                pokemonMaster.getName(),
                pokemonMaster.getCity().getDisplayName(),
                pokemonMaster.getPokemon(),
                pokemonMaster.getCreatedAt(),
                pokemonMaster.getUpdatedAt(),
                pokemonMaster.getActive()
        );
    }

}
