package com.exemple.pokemonmaster;

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
}
