package com.study.pokemonapispring.models;

import com.study.pokemonapispring.dtos.PokemonDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Pokemon")
@Table(name = "pokemons")
@Getter
@NoArgsConstructor
public class Pokemon {
    @Id
    private Integer number;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Integer hp;
    private Integer atk;
    private Integer def;
    private Integer spatk;
    private Integer spdef;
    private Integer speed;

    @Enumerated(EnumType.STRING)
    private Nature nature;

    public Pokemon(PokemonDto pokemonDto) {
        this.number = pokemonDto.number();
        this.name = pokemonDto.name();
        this.type = pokemonDto.type();
        this.hp = pokemonDto.hp();
        this.atk = pokemonDto.atk();
        this.def = pokemonDto.def();
        this.spatk = pokemonDto.spatk();
        this.spdef = pokemonDto.spdef();
        this.speed = pokemonDto.speed();
        this.nature = pokemonDto.nature();
    }
}
