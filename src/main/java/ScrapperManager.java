import java.io.PrintWriter;
import java.util.ArrayList;

public class ScrapperManager {
    public static void main(String[] args) throws Exception {
        String url = "https://rozetka.com.ua/gps-navigators/c80047/filter/";
        String dirPath = "data";
        CategoryScrapper Navigator = new CategoryScrapper(url);
        for (ArrayList<Item> Page : Navigator.getScrappedCategory()) {
            for (Item Product : Page) {
                PrintWriter writer = new PrintWriter(dirPath + "/"+Product.getPageId()+".csv", "UTF-8");
                for (Comment ProductComment : Product.getComments()) {
                   writer.println(ProductComment.getRate().toString() + ",\"" + ProductComment.getText() + "\"");
                }
                writer.close();
            }
        }
    }
}
/*




*/