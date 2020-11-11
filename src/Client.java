import java.util.ArrayList;
import java.util.Date;

public class Client {

    public ArrayList<Facture> getFactureArrayList() {
        return factureArrayList;
    }
    public ArrayList<Location> getLocationArrayList() {
        return locationArrayList;
    }
    public Agence getAgence() {
        return agence;
    }

    private final ArrayList<Facture> factureArrayList;
    private ArrayList<Location> locationArrayList;
    private Compte compte;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;


    private Agence agence;

    public Client(String name, String firstName, Date birthday, Agence agence) {
        this.nom=name;
        this.prenom=firstName;
        this.dateDeNaissance=birthday;
        this.locationArrayList = new ArrayList<>();
        this.factureArrayList = new ArrayList<>();
        this.agence=agence;
        compte=null;
    }

    public Facture commande(ArrayList<Article> articleArrayList, ArrayList<Integer> dureeArrayListLocation){
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

        return getAgence().facture(this,locationArrayList);
    }


    public double payer(Facture facture, MoyenPaiement moyenPaiement){
        facture.setMoyenPaiement(moyenPaiement);
        if (moyenPaiement.equals(MoyenPaiement.COMPTE)){
            System.out.println("Vous devez réapprovisionner votre compte");
            return compte.debiter(facture.getMontant());
        }
        System.out.println("Votre compte a été débité");
        return facture.getMontant();
    }


    public void renduLocation(Location location){
        //TODO : fonction rendre location article

    }

    public void creerCompte(){
        compte=new Compte();
    }
    public Compte getCompte(){
        return compte;
    }

    public void addFacture(Facture facture) {
        this.factureArrayList.add(facture);
    }
}
