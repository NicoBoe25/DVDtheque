public class Categorie {

    private double tarif;
    private String nom;

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Categorie(String nom, double tarif) {
        this.nom = nom;
        this.tarif = tarif;
    }
}
