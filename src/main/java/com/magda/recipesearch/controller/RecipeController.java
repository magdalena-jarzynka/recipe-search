package com.magda.recipesearch.controller;

import com.magda.recipesearch.Ingredient;
import com.magda.recipesearch.SearchResult;
import com.magda.recipesearch.crawler.CrawlerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RecipeController {

    SearchResult searchResult;

    @Autowired
    public RecipeController(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    @GetMapping("/")
    public String helloWorld(Model model, @RequestParam(name = "ingredient", required = false) List<String> ingredients) {
        model.addAttribute("recipes", searchResult.getRecipes());
        if (!CollectionUtils.isEmpty(ingredients)) {
            try {
                CrawlerController.crawl(ingredients, searchResult);

                Path file = Paths.get("list-of-all-ingredients.txt");
                Files.write(file, searchResult.getIngredients().stream().map(Ingredient::getName).collect(Collectors.toList()), StandardCharsets.UTF_8);

                return "search-result-display";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "index";
    }
}
