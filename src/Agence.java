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


    public Facture facture(Client client, ArrayList<Location> locations){
        double somme = 0;
        for (Location l: locations) {
            somme += l.getPrixLocation();
        }
        return new Facture(new Date(),somme,locations,client,"Facture de "+locations.size()+" location(s) le "+new Date());
    }

    public void rembourser(Client client, Location location) {
        if (!(client.getCompte()==null)){
            double prixInitial=location.getPrixLocation();
            long dureeInitiale = location.calcDureeLocation(location.getDateDebutLocation(),location.getDateRetourPrevue());
            long dureeLoc = location.calcDureeLocation(location.getDateDebutLocation(),new Date());
            client.getCompte().credite((prixInitial/(dureeInitiale/12))*((dureeInitiale-dureeLoc)%12));
        }
    }
}
