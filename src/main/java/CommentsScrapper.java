import org.jsoup.nodes.Element;

import java.util.ArrayList;


public class CommentsScrapper extends Scrapper {

    public ArrayList<Comment> getComments() {
        return Comments;
    }

    private ArrayList<Comment> Comments = new ArrayList<Comment>();

    public CommentsScrapper(String url) throws Exception {
        super(url, ".paginator-catalog-l-link");

        Integer pages = 0;

        try {
            pages = Integer.parseInt(Result.last().text());
        } catch (Throwable t) {
        }

        for (Integer k = 1; k <= pages; k++) {
            Scrapper commentPage = new Scrapper(url + "page=" + k.toString() + "/", ".pp-review-inner");
            for (Element comment : commentPage.Result) {
                Comments.add(new Comment(comment.select(".sprite.g-rating-stars-i").attr("content"), comment.select(".pp-review-text-i:first-child").text().replaceAll("\"", "&quot;")));
            }
        }
    }

}
