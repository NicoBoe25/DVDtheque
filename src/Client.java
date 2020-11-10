import java.util.ArrayList;
import java.util.Date;

public class Client {

    public ArrayList<Location> getLocationArrayList() {
        return locationArrayList;
    }

    private ArrayList<Location> locationArrayList;

    public Client() {
        this.locationArrayList = new ArrayList<>();
    }

    public void commande(ArrayList<Article> articleArrayList, ArrayList<Integer> dureeArrayListLocation){
        boolean locationIsOK = true;
        ArrayList<Location> locationsTemp = new ArrayList<Location>();
        for (int i = 0; i < articleArrayList.size(); i++) {
            if (articleArrayList.get(i).isAvailable()) {
                Location loc = new Location(articleArrayList.get(i), dureeArrayListLocation.get(i), "01-01-2021");
                locationsTemp.add(loc);
                loc.getArticle().diminueStock();
            } else {
                locationIsOK = false;
                System.out.println("Le film "+articleArrayList.get(i).getFilm().getNom()+" n'est pas disponible");
            }
        }
        if (locationIsOK){
            System.out.println("Tous les films ont été loué");
        }
        locationArrayList.clear();
        locationArrayList = locationsTemp;
    }


    public void payer(Facture facture){
        //compte-=facture.getMontant();
    }
    public void penalise(){}
    public void renduLocation(){}
}
