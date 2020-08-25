package com.magda.recipesearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/")
    public String helloWorld(Model model) {
        model.addAttribute("hello", "hello World!");
        try {
            CrawlerController.crawl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }
}
