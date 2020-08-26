package com.magda.recipesearch.controller;

import com.magda.recipesearch.Recipe;
import com.magda.recipesearch.crawler.CrawlerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RecipeController {

    Recipe recipe;

    @Autowired
    public RecipeController(Recipe recipe) {
        this.recipe = recipe;
    }

    @GetMapping("/")
    public String helloWorld(Model model, @RequestParam(name = "ingredient") List<String> ingredients) {
        model.addAttribute("recipes", recipe.getRecipeUrls());
        try {
            CrawlerController.crawl(ingredients, recipe);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
