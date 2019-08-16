package com.croz.jokeApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.croz.jokeApp.entities.Joke;
import com.croz.jokeApp.services.JokeService;

@Controller

public class JokeController {
	
	private JokeService service;
	
	@Autowired
	public JokeController(JokeService service) {
		this.service = service;
	}
	//home page
	@RequestMapping("/")
	public String getJokes(Model model) {
		model.addAttribute("jokes", service.getJokes());
		return "home";
	}
	//opens form for adding joke
	@RequestMapping("/new")
	public String newProduct(Model model){
        model.addAttribute("joke", new Joke());
        model.addAttribute("cats", service.getCat());
        return "new";
    }
	//retrieves new joke info and saves it
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String newProduct(@Valid Joke joke, BindingResult bindingResult){
		 if(bindingResult.hasErrors()){
	            return "new";
	        }
		service.saveJoke(joke);
		return "/done";
	}
	//adding a like to a joke
	@RequestMapping("/like/{id}")
	public String likeJoke(@PathVariable Integer id){
		service.likeJoke(id);
        return "redirect:/";
    }
	//adding a dislike to a joke
	@RequestMapping("/dislike/{id}")
	public String dislikeJoke(@PathVariable String id){
		service.dislikeJoke(Integer.parseInt(id));
        return "redirect:/";
    }
	//login page
	@RequestMapping("/login")
	public String login(Model model){
        return "login";
    }
}