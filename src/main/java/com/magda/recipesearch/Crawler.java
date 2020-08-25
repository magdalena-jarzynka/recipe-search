package com.magda.recipesearch;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.Set;
import java.util.regex.Pattern;

public class Crawler extends WebCrawler {

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg|png|mp3|mp4|zip|gz))$");
    static boolean found = false;

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
            String text = htmlParseData.getText();
            String html = htmlParseData.getHtml();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();
            Document document = Jsoup.parse(html);
            Elements divs = document.select("div.article__content");

            if (!found && url.startsWith("https://www.mojewypieki.com/przepis/") && divs.text().contains("kakao")) {
                found = true;
                System.out.println("URL: " + url);
//                System.out.println("TEXT: " + text);
//                System.out.println("HTML: " + html);
//                System.out.println("Text length: " + text.length());
//                System.out.println("Html length: " + html.length());
//                System.out.println("Number of outgoing links: " + links.size());
            }
        }
    }
}
