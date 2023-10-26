package com.exemple.pokemonmaster.pokemon_master;

import com.exemple.pokemonmaster.pokemon_master.domain.PokemonMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonMasterRepository extends JpaRepository<PokemonMaster, Long> {
}
