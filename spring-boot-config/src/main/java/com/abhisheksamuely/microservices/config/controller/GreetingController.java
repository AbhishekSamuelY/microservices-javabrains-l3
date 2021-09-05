package com.abhisheksamuely.microservices.config.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhisheksamuely.microservices.config.beans.DbVariables;

@RestController
// profile can be added to change the behaviour of the program
//@Profile("test")
public class GreetingController {
	
	@Value("${my.greetings}")
	private String greeting;
	
	//default value if property dosent exist
	@Value("${my.greetings: Hello World!}")
	private String greetings;
	
	/*
	 * Get data from CLI
	 * java -jar spring-boot-config-0.0.1-SNAPSHOT.jar --my.greetings="Hello World! from CLI"
	 * */
	
	@Value("static Hello World!")
	private String staticGreetings;
	
	@Value("${my.list.greetingsOfTheDay}")
	private List<String> greetingsOfTheDay;
	/*
	// # evalutes it as SPEL
	@Value("#{${my.map.greetingsOfTheDay}}")
	private Map<String, String> greetingOfTheDay;*/
	
	// provides type safety, group properties together
	@Autowired
	private DbVariables variables;
	
	@Autowired
	private Environment environment;

	@GetMapping("/greeting")
	public String greeting() {
		return greeting+" "+greetingsOfTheDay+"  "+variables;
	}
	
	@GetMapping("/envDetails")
	public String envDetails() {
		return environment.toString();
	}
}
