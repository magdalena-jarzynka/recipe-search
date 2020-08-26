package com.magda.recipesearch.crawler;

import com.magda.recipesearch.Recipe;
import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.regex.Pattern;

public class Crawler extends WebCrawler {

    private static final Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp4|zip|gz))$");
    private final List<String> ingredients;
    private final Recipe recipe;

    public Crawler(List<String> ingredients, Recipe recipe) {
        this.ingredients = ingredients;
        this.recipe = recipe;
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

            if (url.startsWith("https://www.mojewypieki.com/przepis/") && containAllWords(divs.text())) {
                recipe.getRecipeUrls().add(url);
                System.out.println("URL: " + url);
            }
        }
    }

    private boolean containAllWords(String recipe) {
        boolean result = true;
        for (String word : ingredients) {
            if (!recipe.contains(word)) {
                result = false;
                break;
            }
        }
        return result;
    }
}
