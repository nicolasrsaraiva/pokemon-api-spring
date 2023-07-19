package com.study.pokemonapispring.dtos;

import com.study.pokemonapispring.models.Nature;
import com.study.pokemonapispring.models.Pokemon;
import com.study.pokemonapispring.models.Type;

public record PokemonDto(Integer number, String name, Type type, Integer hp, Integer atk, Integer def, Integer spatk, Integer spdef, Integer speed, Nature nature) {

    public PokemonDto(Pokemon pokemon) {
        this(pokemon.getNumber(), pokemon.getName(), pokemon.getType(), pokemon.getHp(), pokemon.getAtk(),
                pokemon.getDef(), pokemon.getSpatk(), pokemon.getSpdef(), pokemon.getSpeed(),
                pokemon.getNature());
    }
}
