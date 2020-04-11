package com.learn.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@RestController
@EnableWebMvc
@ComponentScan("com.learn")
public class RecipeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeApplication.class, args);
	}

	@GetMapping("/")
	public String favRecipe(@RequestParam(value = "name", defaultValue = "Priya") String name) {
		return name + " :: Pappu Buvva";
	}

	@GetMapping("/recipe")
	public Recipe getRecipe(@RequestParam(value = "recipe", defaultValue = "Sambar") String recipeName) {

		Recipe recipe = new Recipe();
		recipe.setId(((Double) Math.random()).intValue() * 100);
		recipe.setName(recipeName);

		recipe.setRefLink("https://www.youtube.com/results?search_query=" + recipeName);
		return recipe;
	}

}
