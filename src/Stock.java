import java.util.ArrayList;

public class Stock {

    public ArrayList<Article> getListarticles() {
        return listarticles;
    }

    private ArrayList<Article> listarticles;

    public Stock(ArrayList<Article> listarticles){
        this.listarticles = listarticles;
    }
}
