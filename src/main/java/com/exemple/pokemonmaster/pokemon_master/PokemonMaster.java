package com.exemple.pokemonmaster.pokemon_master;

import com.exemple.pokemonmaster.pokemon.domain.Pokemon;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pokemon_master")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PokemonMaster {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private City city;
    @OneToMany(mappedBy = "pokemonMaster")
    private List<Pokemon> pokemon;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;


}
