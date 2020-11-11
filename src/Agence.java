import java.util.ArrayList;
import java.util.Date;

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


    public void facture(Client client, ArrayList<Location> locations){
        double somme = 0;
        for (Location l: locations) {
            somme += l.getPrixLocation();
        }
    }

    public void rembourser(Client client, Location location) {
        if (!(client.getCompte()==null)){
            double prixInitial=location.getPrixLocation();
            long dureeInitiale = location.calcDureeLocation(location.getDateRetourPrevue());
            long dureeLoc = location.calcDureeLocation(new Date());
            client.getCompte().credite((prixInitial/(dureeInitiale/12))*((dureeInitiale-dureeLoc)%12));
        }
    }

    public void penaliser(Client client){
        //TODO : fonction penalise

    }
}
