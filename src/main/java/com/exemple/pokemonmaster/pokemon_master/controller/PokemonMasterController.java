package com.exemple.pokemonmaster.pokemon_master.controller;

import com.exemple.pokemonmaster.pokemon_master.request.CreatePokemonMasterRequest;
import com.exemple.pokemonmaster.pokemon_master.response.PokemonMasterDetailsResponse;
import com.exemple.pokemonmaster.pokemon_master.service.PokemonMasterService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pokemon-master")
public class PokemonMasterController {

    private final PokemonMasterService pokemonMasterService;

    public PokemonMasterController(PokemonMasterService pokemonMasterService) {
        this.pokemonMasterService = pokemonMasterService;
    }

    // CRIAR UM POKEMON MASTER
    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid CreatePokemonMasterRequest request, UriComponentsBuilder uriBuilder) {
        var pokemonMaster = pokemonMasterService.create(request);
        var uri = uriBuilder.path("/pokemon-master/{id}").buildAndExpand(pokemonMaster.getId()).toUri();

        return ResponseEntity.created(uri).body(new PokemonMasterDetailsResponse(pokemonMaster));
    }

    // DETALHAR UM POKEMON MASTER PELO ID
    @GetMapping("/details/{id}")
    public ResponseEntity details(@PathVariable Long id) {
        var pokemonMaster = pokemonMasterService.details(id);

        return ResponseEntity.ok(new PokemonMasterDetailsResponse(pokemonMaster));
    }
}
