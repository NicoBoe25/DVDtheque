import java.util.ArrayList;

public class Agence {

    public Stock getStock() {
        return stock;
    }

    private Stock stock;

    public Agence(Stock stock) {
        this.stock = stock;
    }

    public Agence(ArrayList<Article> listArticles){
        this.stock = new Stock(listArticles);
    }


    public void facture(ArrayList<Location> locations){
        double somme = 0;
        for (Location l: locations) {
            somme += l.getPrixLocation();
        }
    }

    public void rembourser(){
    }

    public void penaliser(Client client){

    }
}
