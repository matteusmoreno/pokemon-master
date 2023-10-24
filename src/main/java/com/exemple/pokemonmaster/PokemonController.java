package com.exemple.pokemonmaster;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
