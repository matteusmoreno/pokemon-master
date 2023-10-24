package com.exemple.pokemonmaster.pokemon;

import com.exemple.pokemonmaster.pokemon.domain.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findByName(String name);
}
