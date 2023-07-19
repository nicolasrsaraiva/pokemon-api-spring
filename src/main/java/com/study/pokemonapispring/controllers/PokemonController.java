package com.study.pokemonapispring.controllers;

import com.study.pokemonapispring.models.Pokemon;
import com.study.pokemonapispring.models.Type;
import com.study.pokemonapispring.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    @Autowired
    private PokemonRepository repository;

    @GetMapping("name/{name}")
    public Pokemon readByName(@PathVariable String name){
        return repository.findByName(name);
    }

    @GetMapping("number/{number}")
    public Pokemon readByNumber(@PathVariable Integer number){
        return repository.findByNumber(number);
    }

    @GetMapping("type/{type}")
    public List<Pokemon> readByType(@PathVariable String type){
        type = type.toUpperCase();
        Type typeEnum = Type.valueOf(type);
        return repository.findByType(typeEnum);
    }

    @GetMapping
    public List<Pokemon> readAll(){
        return repository.findAll();
    }

}
