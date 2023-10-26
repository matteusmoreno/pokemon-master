package com.exemple.pokemonmaster.pokemon_master.domain;

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
    @Enumerated(EnumType.STRING)
    private City city;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pokemon_master_id")
    private List<Pokemon> pokemon;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean active;


}
