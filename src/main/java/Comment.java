public class Comment {
    private String Text;
    private Integer Rate;

    public Integer getRate() {
        return Rate;
    }

    public String getText() {
        return Text;
    }

    public Comment(String rate, String data) {
        this.Text = data;
        this.Rate = Integer.parseInt(rate);

    }
}
