package com.exemple.pokemonmaster.pokemon_master.service;

import com.exemple.pokemonmaster.pokemon.PokemonRepository;
import com.exemple.pokemonmaster.pokemon_master.PokemonMasterRepository;
import com.exemple.pokemonmaster.pokemon_master.domain.PokemonMaster;
import com.exemple.pokemonmaster.pokemon_master.request.AddPokemonRequest;
import com.exemple.pokemonmaster.pokemon_master.request.CreatePokemonMasterRequest;
import com.exemple.pokemonmaster.pokemon_master.request.UpdatePokemonMasterRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PokemonMasterService {

    private final PokemonMasterRepository pokemonMasterRepository;
    private final PokemonRepository pokemonRepository;

    public PokemonMasterService(PokemonMasterRepository pokemonMasterRepository, PokemonRepository pokemonRepository) {
        this.pokemonMasterRepository = pokemonMasterRepository;
        this.pokemonRepository = pokemonRepository;
    }

    public PokemonMaster create(CreatePokemonMasterRequest request) {
        PokemonMaster pokemonMaster = new PokemonMaster();
        pokemonMaster.setName(request.name());
        pokemonMaster.setCity(request.city());
        pokemonMaster.setCreatedAt(LocalDateTime.now());
        pokemonMaster.setActive(true);

        pokemonMasterRepository.save(pokemonMaster);
        return pokemonMaster;
    }

    public PokemonMaster details(Long id) {
        return pokemonMasterRepository.findById(id).orElseThrow();
    }

    public PokemonMaster update(UpdatePokemonMasterRequest request) {
        var pokemonMaster = pokemonMasterRepository.findById(request.id()).orElseThrow();

        if (request.name() != null) {
            pokemonMaster.setName(request.name());
        }

        if (request.city() != null) {
            pokemonMaster.setCity(request.city());
        }

        pokemonMaster.setUpdatedAt(LocalDateTime.now());
        pokemonMasterRepository.save(pokemonMaster);

        return pokemonMaster;
    }

    public PokemonMaster disable(Long id) {
        var pokemonMaster = pokemonMasterRepository.findById(id).orElseThrow();
        pokemonMaster.setActive(false);
        pokemonMasterRepository.save(pokemonMaster);

        return pokemonMaster;
    }

    public PokemonMaster active(Long id) {
        var pokemonMaster = pokemonMasterRepository.findById(id).orElseThrow();
        pokemonMaster.setActive(true);
        pokemonMasterRepository.save(pokemonMaster);

        return pokemonMaster;
    }

    public PokemonMaster addPokemon(AddPokemonRequest request) {
        var pokemonMaster = pokemonMasterRepository.findById(request.pokemonMasterId()).orElseThrow();
        var pokemon = pokemonRepository.findById(request.pokemonId()).orElseThrow();

        pokemonMaster.getPokemon().add(pokemon);
        pokemonMasterRepository.save(pokemonMaster);

        return pokemonMaster;
    }
}
