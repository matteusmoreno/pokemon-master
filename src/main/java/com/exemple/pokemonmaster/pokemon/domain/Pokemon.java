package com.exemple.pokemonmaster.pokemon.domain;

import com.exemple.pokemonmaster.pokemon_master.PokemonMaster;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "pokemons")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Pokemon {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private PokemonType type;
    private String image;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_master_id")
    private PokemonMaster pokemonMaster;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;


}
