package com.croz.jokeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.croz.jokeApp.entities.Joke;
@Repository
public interface JokeRepository extends JpaRepository<Joke, Long>{

}
