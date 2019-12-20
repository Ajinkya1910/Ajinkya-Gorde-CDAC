package com.met.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView welcome() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("hello", "Welcome to SpringMVC");  // model data
		modelAndView.setViewName("welcome");
		
		
		return modelAndView;
		
	}
	
	@RequestMapping(value="/welParam", method=RequestMethod.GET)
	public ModelAndView welcomeParam(@RequestParam(required=false) String name,
										@RequestParam int age) {
		
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("hello", "Welcome to SpringMVC name " +name + " and age " + age);  // model data
		modelAndView.setViewName("welcome");
		
		return modelAndView;
		
	}
	
	//@RequestMapping(method=RequestMethod.GET, value="/welPath/{id}")
	@GetMapping("/welPath/{id}")
	public ModelAndView pathWelcome(@PathVariable int id) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("hello", "Welcome to SpringMVC with ID: " + id);  // model data
		modelAndView.setViewName("welcome");
		
		
		return modelAndView;
		
	}
	
}
