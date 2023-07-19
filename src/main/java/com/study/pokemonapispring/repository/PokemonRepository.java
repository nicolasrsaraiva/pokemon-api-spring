package com.study.pokemonapispring.repository;

import com.study.pokemonapispring.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    @Query("SELECT p FROM Pokemon p WHERE p.name = :name")
    Pokemon findByName(@Param("name") String name);
}

