import java.time.LocalDateTime;
import java.util.ArrayList;

public class Facture {
    private LocalDateTime date;
    private double montant;
    private ArrayList<Location>locations;
    private Client client;
    private MoyenPaiement moyenPaiement;
    private boolean paye;
    private String nom;

    public Facture(LocalDateTime date, double montant, ArrayList<Location> locations, Client client, String nom) {
        this.date = date;
        this.montant = montant;
        this.locations = locations;
        this.client = client;
        this.paye = false;
        this.nom=nom;
        client.addFacture(this);
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public MoyenPaiement getMoyenPaiement() {
        return moyenPaiement;
    }

    public void setMoyenPaiement(MoyenPaiement moyenPaiement) {
        this.moyenPaiement = moyenPaiement;
    }

    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
