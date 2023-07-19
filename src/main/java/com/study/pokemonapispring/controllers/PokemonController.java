package com.study.pokemonapispring.controllers;

import com.study.pokemonapispring.dtos.PokemonDto;
import com.study.pokemonapispring.models.Nature;
import com.study.pokemonapispring.models.Type;
import com.study.pokemonapispring.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    @Autowired
    private PokemonRepository repository;

    @GetMapping("name/{name}")
    public PokemonDto readByName(@PathVariable String name) {
        return new PokemonDto(repository.findByName(name));
    }

    @GetMapping("number/{number}")
    public PokemonDto readByNumber(@PathVariable Integer number){
        return new PokemonDto(repository.findByNumber(number));
    }

    @GetMapping("type/{type}")
    public List<PokemonDto> readByType(@PathVariable String type) {
        type = type.toUpperCase();
        Type typeEnum = Type.valueOf(type);
        return repository.findByType(typeEnum).stream().map(PokemonDto::new).collect(Collectors.toList());
    }


    @GetMapping("nature/{nature}")
    public List<PokemonDto> readByNature(@PathVariable String nature){
        nature = nature.toUpperCase();
        Nature natureEnum = Nature.valueOf(nature);
        return repository.findByNature(natureEnum).stream().map(PokemonDto::new).collect(Collectors.toList());
    }

    @GetMapping
    public List<PokemonDto> readAll(){
        return repository.findAllPokemons().stream().map(PokemonDto::new).collect(Collectors.toList());
    }
}
