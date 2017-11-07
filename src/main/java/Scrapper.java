import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Scrapper {
    protected String url;
    public Document Doc;
    public Elements Result;

    public Scrapper(String url) throws Exception {
        this.url = url;
        System.out.println(url);
        Doc = Jsoup.connect(url).timeout(0).get();
    }

    public Scrapper(String url, String selector) throws Exception {
        this(url);
        Result = Doc.select(selector);
    }
}

