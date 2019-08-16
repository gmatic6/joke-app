package com.croz.jokeApp.entities;

import java.util.Comparator;

//TODO: create likeable interface to sort more types of objects
public class JokeSorter implements Comparator<Joke>{
	//sorts jokes by like/dislike ratio
	public int compare(Joke arg0, Joke arg1) {
		int razlika0 = arg0.getLikes()-arg0.getDislikes();
		int razlika1 = arg1.getLikes()-arg1.getDislikes();
		if(razlika0 < razlika1) return 1;
		return -1;
	}

}
