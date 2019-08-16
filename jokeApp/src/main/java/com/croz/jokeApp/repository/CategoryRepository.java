package com.croz.jokeApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.croz.jokeApp.entities.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}