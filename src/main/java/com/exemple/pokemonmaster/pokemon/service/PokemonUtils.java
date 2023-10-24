package com.exemple.pokemonmaster.pokemon.service;

import com.exemple.pokemonmaster.pokemon.domain.Pokemon;
import com.exemple.pokemonmaster.pokemon.request.CreatePokemonRequest;
import com.exemple.pokemonmaster.pokemon.request.UpdatePokemonRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PokemonUtils {


    public void setCreateAttributes(Pokemon pokemon, CreatePokemonRequest request) {
        pokemon.setName(request.name());
        pokemon.setType(request.type());
        pokemon.setImage(request.image());
        pokemon.setDescription(request.description());
        pokemon.setCreatedAt(LocalDateTime.now());
        pokemon.setActive(true);
    }

    public void setUpdateAttributes(Pokemon pokemon, UpdatePokemonRequest request) {
        if (request.name() != null) {
            pokemon.setName(request.name());
        }

        if (request.type() != null) {
            pokemon.setType(request.type());
        }

        if (request.image() != null) {
            pokemon.setImage(request.image());
        }

        if (request.description() != null) {
            pokemon.setDescription(request.description());
        }

        pokemon.setUpdatedAt(LocalDateTime.now());
    }
}
