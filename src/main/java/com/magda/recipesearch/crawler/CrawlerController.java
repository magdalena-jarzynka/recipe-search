package com.magda.recipesearch.crawler;

import com.magda.recipesearch.Ingredient;
import com.magda.recipesearch.SearchResult;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import java.util.List;
import java.util.stream.Collectors;

public class CrawlerController {

    private CrawlerController() {
    }

    public static void crawl(List<Ingredient> ingredients, SearchResult searchResult) throws Exception {

        String crawlStorageFolder = "data/crawl/root";
        int numberOfCrawlers = 7;
        int maxDepthOfCrawling = 1;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxDepthOfCrawling(maxDepthOfCrawling);
        config.setPolitenessDelay(10);
        config.setCleanupDelaySeconds(1);
        config.setThreadMonitoringDelaySeconds(1);
        config.setThreadShutdownDelaySeconds(1);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        for (int i = 1; i <= 5; i++) {
            controller.addSeed("https://www.mojewypieki.com/posty/?_paged=" + i);
        }
        searchResult.getRecipes().clear();

        CrawlController.WebCrawlerFactory<Crawler> factory = () -> new Crawler(ingredients.stream().map(Ingredient::getRegex).collect(Collectors.toList()), searchResult);

        controller.start(factory, numberOfCrawlers);
    }
}
