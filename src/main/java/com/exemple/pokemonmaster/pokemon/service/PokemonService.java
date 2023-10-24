package com.exemple.pokemonmaster.pokemon.service;

import com.exemple.pokemonmaster.pokemon.PokemonRepository;
import com.exemple.pokemonmaster.pokemon.domain.Pokemon;
import com.exemple.pokemonmaster.pokemon.request.CreatePokemonRequest;
import com.exemple.pokemonmaster.pokemon.request.UpdatePokemonRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon create(CreatePokemonRequest request) {
        Pokemon pokemon = new Pokemon();

        pokemon.setName(request.name());
        pokemon.setType(request.type());
        pokemon.setImage(request.image());
        pokemon.setDescription(request.description());
        pokemon.setCreatedAt(LocalDateTime.now());
        pokemon.setActive(true);

        pokemonRepository.save(pokemon);

        return pokemon;
    }

    public Pokemon detailsById(Long id) {
        return pokemonRepository.findById(id).orElseThrow();
    }

    public Pokemon detailsByName(String name) {
        return pokemonRepository.findByName(name);
    }

    public Pokemon update(UpdatePokemonRequest request) {
        var pokemon = pokemonRepository.findById(request.id()).orElseThrow();

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
        pokemonRepository.save(pokemon);

        return pokemon;
    }
}
