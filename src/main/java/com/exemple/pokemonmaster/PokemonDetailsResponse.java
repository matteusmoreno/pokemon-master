package com.exemple.pokemonmaster;

import java.time.LocalDateTime;

public record PokemonDetailsResponse(
        Long id,
        String name,
        String type,
        String image,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        Boolean active) {

    public PokemonDetailsResponse(Pokemon pokemon) {
        this(
                pokemon.getId(),
                pokemon.getName(),
                pokemon.getType().getDisplayName(),
                pokemon.getImage(),
                pokemon.getDescription(),
                pokemon.getCreatedAt(),
                pokemon.getUpdatedAt(),
                pokemon.getActive()

        );
    }
}
