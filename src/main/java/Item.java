import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Item {
    private ArrayList<Comment> Comments = new ArrayList<Comment>();
    private String PageId;

    public ArrayList<Comment> getComments() {
        return Comments;
    }


    public String getPageId() {
        return PageId;
    }

    public Item(String url) throws Exception {
        Comments = new CommentsScrapper(url).getComments();

    }

    public Item(Item A) {
        PageId = A.PageId;
        Comments = A.Comments;
    }
}
