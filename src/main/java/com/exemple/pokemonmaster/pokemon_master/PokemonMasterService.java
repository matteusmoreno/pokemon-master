package com.exemple.pokemonmaster.pokemon_master;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PokemonMasterService {

    private final PokemonMasterRepository pokemonMasterRepository;

    public PokemonMasterService(PokemonMasterRepository pokemonMasterRepository) {
        this.pokemonMasterRepository = pokemonMasterRepository;
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
}
