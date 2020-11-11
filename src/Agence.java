import java.time.LocalDateTime;
import java.util.ArrayList;

public class Agence {

    public Stock getStock() {
        return stock;
    }

    private Stock stock;
    private ArrayList<Client>clients;

    public Agence(ArrayList<Article> listArticles){
        this.stock = new Stock(listArticles);
    }


    public Facture facture(Client client, ArrayList<Location> locations){
        double somme = 0;
        for (Location l: locations) {
            somme += l.getPrix();
        }
        return new Facture(LocalDateTime.now(), somme, locations, client, "Facture de " + locations.size() + " location(s) le " + LocalDateTime.now());
    }

    public void rembourser(Client client, Location location) {
        if (!(client.getCompte()==null)){
            double prixInitial=location.getPrix();
            long dureeInitiale = location.calcDureeHoursLocation(location.getDateDebut(),location.getDateRetour());
            long dureeLoc = location.calcDureeHoursLocation(location.getDateDebut(), LocalDateTime.now());
            if (dureeLoc==0) dureeLoc=1;
            double remboursement = (prixInitial/(dureeInitiale))*((dureeInitiale-dureeLoc));
            client.getCompte().credite(remboursement);
            System.out.println("Vous avez été remboursé de "+remboursement);
        }
    }
}
