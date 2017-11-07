import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CategoryScrapper extends Scrapper {

    protected ArrayList<ArrayList<Item>> ScrappedCategory;

    public CategoryScrapper(String url) throws Exception {
        super(url, ".paginator-catalog-l-link");
        ;
        ScrapCategory();
    }

    private void ScrapCategory() throws Exception {
        ScrapCategory(1);
    }

    private void ScrapCategory(int cooldown) throws Exception {
        Integer pages = 0;
        try {
            pages = Integer.parseInt(Result.last().text());
        } catch (Throwable t) {
        }
        ScrappedCategory = new ArrayList<ArrayList<Item>>();

        for (Integer i = 1; i <= pages; i++) {
            TimeUnit.SECONDS.sleep(cooldown);
            ScrappedCategory.add(new ItemScrapper(url + "page=" + i.toString() + "/").getItems());
        }

    }

    public ArrayList<ArrayList<Item>> getScrappedCategory() {
        return ScrappedCategory;
    }
}
