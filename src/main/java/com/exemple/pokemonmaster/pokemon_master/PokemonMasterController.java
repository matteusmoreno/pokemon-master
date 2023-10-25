package com.exemple.pokemonmaster.pokemon_master;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pokemon-master")
public class PokemonMasterController {

    private final PokemonMasterService pokemonMasterService;

    public PokemonMasterController(PokemonMasterService pokemonMasterService) {
        this.pokemonMasterService = pokemonMasterService;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreatePokemonMasterRequest request, UriComponentsBuilder uriBuilder) {
        var pokemonMaster = pokemonMasterService.create(request);
        var uri = uriBuilder.path("/pokemon-master/{id}").buildAndExpand(pokemonMaster.getId()).toUri();

        return ResponseEntity.created(uri).body(new PokemonMasterDetailsResponse(pokemonMaster));
    }
}
