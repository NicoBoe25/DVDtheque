public enum Categorie {

    NOUVEAUTE(2.5), RECENT(1.75), ANNEE(1), AN_PASSE(0.75), ANCIEN(0.5) ;

    private double tarif;
    Categorie(double v) {
        this.tarif = v ;

    }

    public double getTarif() {
        return tarif;
    }


}
