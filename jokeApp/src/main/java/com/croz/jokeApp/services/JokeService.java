package com.croz.jokeApp.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.croz.jokeApp.entities.Category;
import com.croz.jokeApp.entities.Joke;
import com.croz.jokeApp.entities.JokeSorter;
import com.croz.jokeApp.repository.CategoryRepository;
import com.croz.jokeApp.repository.JokeRepository;

@Service
public class JokeService {
	
	//TODO: get jokes via SQL command instead of findAll method
	
	private JokeRepository repository;
	private CategoryRepository repository2;
	@Autowired
	public JokeService(JokeRepository repository, CategoryRepository repository2) {
		this.repository=repository;
		this.repository2=repository2;
	}
	//retrieves jokes from repository and sorts them by like/dislike ratio
	public List<Joke> getJokes() {
		List<Joke> jokes = repository.findAll();
		Joke.setNumberOfJokes(jokes.size());
		Collections.sort(jokes, new JokeSorter());
		return jokes;
	}
	//retrieves categories
	public List<Category> getCat() {
		List<Category> cats = new ArrayList<>();
		repository2.findAll().forEach(cats::add);
		return cats;
	}

	//saves joke if it doesn't exist in repository
	public void saveJoke(Joke joke) {
		ArrayList<Joke> jokes = (ArrayList<Joke>) getJokes();
		for(Joke oneJoke : jokes) {
			if(oneJoke.getContent().equals(joke.getContent()) && oneJoke.getCategory().getId() == joke.getCategory().getId()) {
				return;
			}
		}
		Joke.setNumberOfJokes(Joke.getNumberOfJokes() + 1);
		joke.setId(Joke.getNumberOfJokes());
		repository.save(joke);
	}
	//adds one like to joke and saves it
	public void likeJoke(int jokeId) {
		List<Joke> jokes = new ArrayList<>();
		repository.findAll().forEach(jokes::add);
		for(Joke updatedJoke : jokes) {
			if(updatedJoke.getId() == jokeId) {
				updatedJoke.setLikes(updatedJoke.getLikes()+1);
				repository.save(updatedJoke);
			}
		}
	}
	//adds one dislike to joke and saves it
	public void dislikeJoke(int jokeId) {
		List<Joke> jokes = new ArrayList<>();
		repository.findAll().forEach(jokes::add);
		for(Joke updatedJoke : jokes) {
			if(updatedJoke.getId() == jokeId) {
				updatedJoke.setDislikes(updatedJoke.getDislikes()+1);
				repository.save(updatedJoke);
			}
		}
	}
}
