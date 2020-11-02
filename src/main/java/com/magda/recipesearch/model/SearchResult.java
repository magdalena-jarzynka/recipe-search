package com.magda.recipesearch.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SearchResult {

    private List<Recipe> recipes = Collections.synchronizedList(new ArrayList<>());

    public List<Recipe> getRecipes() {
        return recipes;
    }

}
