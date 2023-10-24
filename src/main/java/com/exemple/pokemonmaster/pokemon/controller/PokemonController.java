package com.exemple.pokemonmaster.pokemon.controller;

import com.exemple.pokemonmaster.pokemon.service.PokemonService;
import com.exemple.pokemonmaster.pokemon.request.CreatePokemonRequest;
import com.exemple.pokemonmaster.pokemon.response.PokemonDetailsResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService pokemonService;
    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create (@RequestBody @Valid CreatePokemonRequest request, UriComponentsBuilder uriBuilder) {
        var pokemon = pokemonService.create(request);
        var uri = uriBuilder.path("/pokemons/{id}").buildAndExpand(request.name()).toUri();

        return ResponseEntity.created(uri).body(new PokemonDetailsResponse(pokemon));
    }

    @GetMapping("/detailsbyid/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var pokemon = pokemonService.detailsById(id);

        return ResponseEntity.ok(new PokemonDetailsResponse(pokemon));
    }

    @GetMapping("/detailsbyname/{name}")
    public ResponseEntity getByName(@PathVariable String name) {
        var pokemon = pokemonService.detailsByName(name);

        return ResponseEntity.ok(new PokemonDetailsResponse(pokemon));
    }
}
