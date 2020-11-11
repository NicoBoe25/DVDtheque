
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    private ArrayList<Reservation> reservations;
    private Compte compte;
    private String nom;
    private String prenom;
    private LocalDateTime dateDeNaissance;


    private Agence agence;

    public Client(String name, String firstName, String birthday, Agence agence) {
        this.nom=name;
        this.prenom=firstName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.dateDeNaissance = LocalDateTime.parse(birthday, formatter);
        this.locationArrayList = new ArrayList<>();
        this.factureArrayList = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.agence=agence;
        compte=null;
    }

    public Facture commande(ArrayList<Article> articleArrayList, ArrayList<String> dateArrayListLocation){
        boolean locationIsOK = true;
        ArrayList<Location> locationsTemp = new ArrayList<Location>();
        for (int i = 0; i < articleArrayList.size(); i++) {
            if (articleArrayList.get(i).isAvailable()) {
                Location loc = new Location(articleArrayList.get(i), dateArrayListLocation.get(i));
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

    public void reserver(Article article, String date){
        reservations.add(new Reservation(date, article));
    }


    public double payer(Facture facture, MoyenPaiement moyenPaiement){
        facture.setMoyenPaiement(moyenPaiement);
        if (moyenPaiement.equals(MoyenPaiement.COMPTE)){
            double solde =compte.debiter(facture.getMontant());
            if (solde<0){
                System.out.println("Vous devez réapprovisionner votre compte");
            }else {
                System.out.println("Votre compte a été débité");
            }
            return solde;
        }
        return facture.getMontant();
    }


    public void rendLocation(Location location){
        location.getArticle().augmenteStock();
        LocalDateTime dateRetournee = LocalDateTime.now();
        if (location.getDateRetourPrevue().compareTo(dateRetournee) < 0){
            Location locationPenalite = new Location(location.getArticle(), location.getDateRetourPrevue().toString());
            ArrayList<Location> arrayLocationPenalisée = new ArrayList<>();
            arrayLocationPenalisée.add(locationPenalite);
            factureArrayList.add(new Facture(dateRetournee,locationPenalite.getPrixLocation(),arrayLocationPenalisée,this,"Penalite de retard"));
        }else if ((compte!=null) && ( location.getDateRetourPrevue().compareTo(dateRetournee) > 0 )){
            agence.rembourser(this,location);
        }
        System.out.println("L'article "+location.getArticle().getFilm().getNom()+" a bien été rendu");

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
