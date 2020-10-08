import java.util.ArrayList;

public class Agence {

    private Stock stock;

    public Agence() {}

    public Agence(Stock stock) {
        this.stock = stock;
    }

    public Agence(ArrayList<Film> listFilm){
        this.stock = new Stock(listFilm);
    }
}
