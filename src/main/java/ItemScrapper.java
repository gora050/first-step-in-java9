import org.jsoup.nodes.Element;
import java.io.IOException;

import java.util.ArrayList;

public class ItemScrapper extends Scrapper {

    private ArrayList<Item> ScrappedItems = new ArrayList<Item>();
    private String DirPath;

    public ArrayList<Item> getItems() {
        return new ArrayList<Item>(ScrappedItems);
    }

    public String getDirPath() {
        return DirPath;
    }


    public ItemScrapper(String url) throws Exception {
        this(url,"data");
    }

    public ItemScrapper(String url, String DirPath) throws Exception {
        super(url, ".g-i-tile-i-title.clearfix a");
        this.DirPath = DirPath;
        scrapItems();
    }


    private void scrapItems() throws Exception {
        for (Element item : Result) {
            ScrappedItems.add(new Item(item.attr("href")));
        }
    }

}
