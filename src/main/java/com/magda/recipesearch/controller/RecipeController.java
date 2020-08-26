package com.magda.recipesearch.controller;

import com.magda.recipesearch.SearchResult;
import com.magda.recipesearch.crawler.CrawlerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RecipeController {

    SearchResult searchResult;

    @Autowired
    public RecipeController(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    @GetMapping("/")
    public String helloWorld(Model model, @RequestParam(name = "ingredient") List<String> ingredients) {
        model.addAttribute("recipes", searchResult.getRecipes());
        try {
            CrawlerController.crawl(ingredients, searchResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
