package com.exemple.pokemonmaster.pokemon_master.controller;

import com.exemple.pokemonmaster.pokemon_master.request.AddPokemonRequest;
import com.exemple.pokemonmaster.pokemon_master.request.CreatePokemonMasterRequest;
import com.exemple.pokemonmaster.pokemon_master.request.UpdatePokemonMasterRequest;
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

    // ATUALIZAR UM POKEMON MASTER
    @PutMapping("/update")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdatePokemonMasterRequest request) {
        var pokemonMaster = pokemonMasterService.update(request);

        return ResponseEntity.ok(new PokemonMasterDetailsResponse(pokemonMaster));
    }

    // DESATIVAR UM POKEMON MASTER
    @PutMapping("/disable/{id}")
    @Transactional
    public ResponseEntity disable(@PathVariable Long id) {
        var pokemonMaster = pokemonMasterService.disable(id);

        return ResponseEntity.ok(new PokemonMasterDetailsResponse(pokemonMaster));
    }

    // ATIVAR UM POKEMON MASTER
    @PutMapping("/active/{id}")
    @Transactional
    public ResponseEntity active(@PathVariable Long id) {
        var pokemonMaster = pokemonMasterService.active(id);

        return ResponseEntity.ok(new PokemonMasterDetailsResponse(pokemonMaster));
    }

    // ADICIONAR UM POKEMON AO POKEMON MASTER
    @PutMapping("/add-pokemon")
    @Transactional
    public ResponseEntity addPokemon(@RequestBody @Valid AddPokemonRequest request) {
        var pokemonMaster = pokemonMasterService.addPokemon(request);

        return ResponseEntity.ok(new PokemonMasterDetailsResponse(pokemonMaster));
    }
}
