public class Compte {
    public final static double CADEAU_OUVERTURE_COMPTE_TROP_TROP_BIEN=5;
    private double montant;

    public Compte() {
        montant = CADEAU_OUVERTURE_COMPTE_TROP_TROP_BIEN;
    }

    public double getMontant() {
        return montant;
    }

    public void credite(double argent){
        montant+=argent;
    }

    public double debiter(double argent){
        if (montant<argent)return -1;
        montant-=argent;
        return argent;
    }
}
