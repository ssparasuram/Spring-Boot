package com.learn.recipe;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

	@GetMapping("/recipelist")
	public List<String> getRecipes(@RequestParam(value="data",defaultValue = "") String recipe) {
		
		String[] recipes = {"Sambar", "Rasam","vendai kai","Tomoto"};
		
		if(recipe != null) {
			
			return Arrays.asList(recipes).stream().filter(x -> x.toLowerCase().startsWith(recipe.toLowerCase())).collect(Collectors.toList());
		}
		
		return Arrays.asList(recipes).stream().collect(Collectors.toList());
		
		
	}
}
