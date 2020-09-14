package com.magda.recipesearch.crawler;

import com.magda.recipesearch.SearchResult;
import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

import java.util.List;

public class CrawlerController {

    private CrawlerController() {
    }

    public static void crawl(List<String> ingredients, SearchResult searchResult) throws Exception {

        String crawlStorageFolder = "data/crawl/root";
        int maxPagesToFetch = 50;
        int numberOfCrawlers = 7;
        int maxDepthOfCrawling = 1;

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxPagesToFetch(maxPagesToFetch);
        config.setMaxDepthOfCrawling(maxDepthOfCrawling);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        controller.addSeed("https://www.mojewypieki.com");

        searchResult.getRecipes().clear();

        CrawlController.WebCrawlerFactory<Crawler> factory = () -> new Crawler(ingredients, searchResult);

        controller.start(factory, numberOfCrawlers);
    }
}
