import java.util.Date;

public class Reservation {
    private Date date;
    private Article article;

    public Reservation(Date date, Article article) {
        this.date = date;
        this.article = article;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
