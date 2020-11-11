import java.util.ArrayList;

public class Stock {

    public ArrayList<Article> getArticles() {
        return articles;
    }

    private ArrayList<Article> articles;

    public Stock(ArrayList<Article> articles){
        this.articles = articles;
    }
}
