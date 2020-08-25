package com.magda.recipesearch;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Recipe {

    private List<String> recipeUrls = Collections.synchronizedList(new ArrayList<>());

    public List<String> getRecipeUrls() {
        return recipeUrls;
    }
}
