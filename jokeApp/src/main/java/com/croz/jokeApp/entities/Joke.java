package com.croz.jokeApp.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Joke{
	//TODO: implement automatic ID assign
	private static int numberOfJokes;
	@Id
	private int id;
	@NotNull
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	@NotNull
	private String content;
	@NotNull
	private int likes;
	@NotNull
	private int dislikes;
		
	public Joke() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public static int getNumberOfJokes() {
		return numberOfJokes;
	}
	public static void setNumberOfJokes(int numberOfJokes) {
		Joke.numberOfJokes = numberOfJokes;
	}
}
