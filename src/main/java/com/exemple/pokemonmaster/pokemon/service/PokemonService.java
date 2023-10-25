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
    private final PokemonUtils pokemonUtils;
    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, PokemonUtils pokemonUtils) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonUtils = pokemonUtils;
    }

    public Pokemon create(CreatePokemonRequest request) {
        Pokemon pokemon = new Pokemon();
        pokemonUtils.setCreateAttributes(pokemon, request);
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
        pokemonUtils.setUpdateAttributes(pokemon, request);
        pokemonRepository.save(pokemon);

        return pokemon;
    }

    public Pokemon desactive(Long id) {
        var pokemon = pokemonRepository.findById(id).orElseThrow();
        pokemon.setActive(false);
        pokemonRepository.save(pokemon);
        return pokemon;

    }

    public Pokemon active(Long id) {
        var pokemon = pokemonRepository.findById(id).orElseThrow();
        pokemon.setActive(true);
        pokemonRepository.save(pokemon);
        return pokemon;
    }
}
