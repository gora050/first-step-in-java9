import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.concurrent.TimeUnit;

public class Scrapper {
    public static void main(String[] args) throws IOException, InterruptedException {
        String url = "https://rozetka.com.ua/gps-navigators/c80047/filter/";
        System.out.println(url);
        parseCategory(url);
    }

    private static void parseCategory(String url) throws IOException, InterruptedException {
        Document doc = Jsoup.connect(url).timeout(0).get();

        Integer pages = Integer.parseInt(doc.select(".paginator-catalog-l-link").last().text());


        for (Integer i = 1; i<=pages;i++) {
            System.out.println("Sleeping between pages...");
            TimeUnit.SECONDS.sleep(1);
            parseItems(url + "page="+i.toString()+"/");
        }

    }

    private static void parseItems(String url) throws IOException, InterruptedException {
        System.out.println(url);

                Document page = Jsoup.connect(url).timeout(0).get();
        Elements items = page.select(".g-i-tile-i-title.clearfix a");
        new File("data").mkdirs();
        for (Element item : items) {
            PrintWriter writer = new PrintWriter("data/"+item.attr("href").split("/")[4]+".csv", "UTF-8");

            parseItem(item.attr("href"), writer);

            writer.close();
        }
    }

    public static void parseItem(String url, PrintWriter writer) throws IOException {

        System.out.println(url);

        Document testPage = Jsoup.connect(url+"comments/").timeout(0).get();
        Integer cpages = 0;
        try {
            cpages = Integer.parseInt(testPage.select(".paginator-catalog-l-link").last().text());
        } catch (Throwable t) {
        }
        for (Integer k = 1; k<=cpages;k++) {
            System.out.println(url+"comments/page="+k.toString()+"/");
            Document commentPage = Jsoup.connect(url+"comments/page="+k.toString()+"/").timeout(0).get();
            Elements comments = commentPage.select(".pp-review-inner");
            for (Element comment : comments) {
                writer.println(comment.select(".sprite.g-rating-stars-i").attr("content")+",\""+comment.select(".pp-review-text-i:first-child").text().replaceAll("\"","&quot;")+"\"");
            }
        }
    }


}

