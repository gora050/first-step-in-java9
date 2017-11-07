import java.io.PrintWriter;
import java.util.ArrayList;

public class ScrapperManager {
    public static void main(String[] args) throws Exception {
        String url = "https://rozetka.com.ua/gps-navigators/c80047/filter/";
        System.out.println(url);
        CategoryScrapper Navigator = new CategoryScrapper(url);
        for (ArrayList<Item> Page : Navigator.getScrappedCategory()) {
            for (Item Product : Page) {
                for (Comment ProductComment : Product.getComments()) {
                    System.out.println(ProductComment.data);

                }
            }
        }
    }
}
/*
        new File(dirPath).mkdirs();

    PrintWriter writer = new PrintWriter(dirPath + "/"+item.attr("href").split("/")[4]+".csv", "UTF-8");

            writer.close();
*/