package com.study.pokemonapispring.controllers;

import com.study.pokemonapispring.dtos.PokemonDto;
import com.study.pokemonapispring.models.Pokemon;
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
    public void readByNumber(@PathVariable Integer number){

    }

    @GetMapping("type/{type}")
    public void readByType(@PathVariable String type){

    }

    @GetMapping
    public List<Pokemon> readAll(){
        return repository.findAll();
    }

}
