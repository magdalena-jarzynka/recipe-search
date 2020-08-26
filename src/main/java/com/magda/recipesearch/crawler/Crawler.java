package com.magda.recipesearch.crawler;

import com.magda.recipesearch.Recipe;
import com.magda.recipesearch.SearchResult;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Crawler extends WebCrawler {

    private static final Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp4|zip|gz))$");
    private final List<String> ingredients;
    private final SearchResult searchResult;

    public Crawler(List<String> ingredients, SearchResult searchResult) {
        this.ingredients = ingredients;
        this.searchResult = searchResult;
    }

    @Override
    public boolean shouldVisit(Page referringPage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches()
                && href.startsWith("https://www.mojewypieki.com/przepis/");
    }

    @Override
    public void visit(Page page) {
        String url = page.getWebURL().getURL();

        if (page.getParseData() instanceof HtmlParseData) {
            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            String html = htmlParseData.getHtml();
            Document document = Jsoup.parse(html);
            Elements divs = document.select("div.article__content");
            Elements title = document.select("div.title");
            Elements images = divs.select("img");
            String imageUrl = images.attr("data-src");


            if (url.startsWith("https://www.mojewypieki.com/przepis/") && containAllWords(divs.text())) {
                Recipe recipe = new Recipe();
                recipe.setUrl(url);
                recipe.setTitle(title.text());
                recipe.setImageUrl(imageUrl);
                searchResult.getRecipes().add(recipe);
                System.out.println("Title: " + recipe.getTitle());
                System.out.println("URL: " + recipe.getUrl());
                System.out.println("ImageUrl: " + recipe.getImageUrl());
            }
        }
    }

    private boolean containAllWords(String recipe) {
        boolean result = true;
        for (String ingredient : ingredients) {
            if (!containsWord(ingredient, recipe)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean containsWord(String word, String source) {
        String pattern = "\\b" + word + "\\b";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        return m.find();
    }
}
