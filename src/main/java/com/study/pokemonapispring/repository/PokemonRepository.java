package com.study.pokemonapispring.repository;

import com.study.pokemonapispring.models.Pokemon;
import com.study.pokemonapispring.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    @Query("SELECT p FROM Pokemon p WHERE p.name = :name")
    Pokemon findByName(@Param("name") String name);

    @Query("SELECT p FROM Pokemon p WHERE p.number = :number")
    Pokemon findByNumber(@Param("number") Integer number);

    @Query("SELECT p FROM Pokemon p WHERE p.type = :type")
    List<Pokemon> findByType(@Param("type") Type type);

}

