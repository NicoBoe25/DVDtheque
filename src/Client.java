import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Client {


    public ArrayList<Facture> getFactures() {
        return factures;
    }
    public ArrayList<Location> getLocations() {
        return locations;
    }
    public Agence getAgence() {
        return agence;
    }

    private final ArrayList<Facture> factures;
    private ArrayList<Location> locations;
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    private ArrayList<Reservation> reservations;
    private Compte compte;
    private String nom;
    private String prenom;
    private LocalDateTime dateNaissance;


    private Agence agence;

    public Client(String name, String firstName, String birthday, Agence agence) {
        this.nom=name;
        this.prenom=firstName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.dateNaissance = LocalDateTime.parse(birthday, formatter);
        this.locations = new ArrayList<>();
        this.factures = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.agence=agence;
        compte=null;
    }

    public Facture commander(ArrayList<Article> articleArrayList, ArrayList<String> dateArrayListLocation){
        boolean locationIsOK = true;
        ArrayList<Location> locationsTemp = new ArrayList<Location>();
        for (int i = 0; i < articleArrayList.size(); i++) {
            if (articleArrayList.get(i).isAvailable()) {
                Location loc = new Location(articleArrayList.get(i), dateArrayListLocation.get(i));
                locationsTemp.add(loc);
                loc.getArticle().diminueStock();
            } else {
                locationIsOK = false;
                System.out.println("Le film "+articleArrayList.get(i).getFilm().getTitre()+" n'est pas disponible");
            }
        }
        if (locationIsOK){
            System.out.println("Tous les films ont été loué");
        }
        locations.clear();
        locations = locationsTemp;

        return getAgence().facture(this, locations);
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


    public void rendreLocation(Location location){
        location.getArticle().augmenteStock();
        LocalDateTime dateRetournee = LocalDateTime.now();
        if (location.getDateRetour().compareTo(dateRetournee) < 0){
            Location locationPenalite = new Location(location.getArticle(), location.getDateRetour().toString());
            ArrayList<Location> arrayLocationPenalisée = new ArrayList<>();
            arrayLocationPenalisée.add(locationPenalite);
            factures.add(new Facture(dateRetournee,locationPenalite.getPrix(),arrayLocationPenalisée,this,"Penalite de retard"));
        }else if ((compte!=null) && ( location.getDateRetour().compareTo(dateRetournee) > 0 )){
            agence.rembourser(this,location);
        }
        System.out.println("L'article "+location.getArticle().getFilm().getTitre()+" a bien été rendu");

    }

    public void creerCompte(){
        compte=new Compte();
    }
    public Compte getCompte(){
        return compte;
    }

    public void addFacture(Facture facture) {
        this.factures.add(facture);
    }
}
