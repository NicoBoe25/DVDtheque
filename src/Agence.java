import java.util.ArrayList;

public class Agence {

    public Stock getStock() {
        return stock;
    }

    private Stock stock;

    public Agence(Stock stock) {
        this.stock = stock;
    }

    public Agence(ArrayList<Film> listFilm){
        this.stock = new Stock(listFilm);
    }
}
