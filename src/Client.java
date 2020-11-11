import com.sun.xml.internal.bind.v2.TODO;

import java.util.ArrayList;

public class Client {

    public ArrayList<Location> getLocationArrayList() {
        return locationArrayList;
    }

    private ArrayList<Location> locationArrayList;
    private Compte compte;

    public Client() {
        this.locationArrayList = new ArrayList<>();
        compte=null;
    }

    public void commande(ArrayList<Article> articleArrayList, ArrayList<Integer> dureeArrayListLocation){
        boolean locationIsOK = true;
        ArrayList<Location> locationsTemp = new ArrayList<Location>();
        for (int i = 0; i < articleArrayList.size(); i++) {
            if (articleArrayList.get(i).isAvailable()) {
                Location loc = new Location(articleArrayList.get(i), "01-01-2021");
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


    public double payer(Facture facture){
        if (facture.getMoyenPaiement().equals(MoyenPaiement.COMPTE)){
            System.out.println("Vous devez réapprovisionner votre compte");
            return compte.debiter(facture.getMontant());
        }
        System.out.println("Votre compte a été débité");
        return facture.getMontant();
    }
    public void penalise(){
        //TODO : fonction penalise
    }
    public void renduLocation(){
        //TODO : fonction rendre location article

    }

    public void creerCompte(){
        compte=new Compte();
    }
    public Compte getCompte(){
        return compte;
    }
}
