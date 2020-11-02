package com.magda.recipesearch.controller;

import com.magda.recipesearch.model.Ingredient;
import com.magda.recipesearch.model.SearchResult;
import com.magda.recipesearch.crawler.CrawlerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
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
    public String searchRecipes(Model model, @RequestParam(name = "ingredient", required = false) List<String> ingredientNames) {
        model.addAttribute("recipes", searchResult.getRecipes());
        model.addAttribute("allIngredients", Arrays.stream(Ingredient.values()).map(Ingredient::getDisplayName).sorted().collect(Collectors.toList()));
        if (!CollectionUtils.isEmpty(ingredientNames)) {
            List<Ingredient> ingredients = ingredientNames.stream().map(Ingredient::mapDisplayNameToIngredient).collect(Collectors.toList());
            try {
                CrawlerController.crawl(ingredients, searchResult);
                return "search-result-display";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "index";
    }
}
