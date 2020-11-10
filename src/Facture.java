import java.util.ArrayList;
import java.util.Date;

public class Facture {
    private Date date;
    private double montant;
    private ArrayList<Location>locations;
    private Client client;
    private MoyenPaiement moyenPaiement;

    public Facture(Date date, double montant, ArrayList<Location> locations, Client client, MoyenPaiement moyenPaiement) {
        this.date = date;
        this.montant = montant;
        this.locations = locations;
        this.client = client;
        this.moyenPaiement = moyenPaiement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
