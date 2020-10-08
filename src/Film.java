public class Film {

    //-------------------------Getters-----------------------------//
    public int getNbExemplaire() {
        return nbExemplaire;
    }

    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }

    public Categorie getCat() {
        return cat;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    //-------------------------Setters-----------------------------//
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }

    //-------------------------Fields-----------------------------//
    private int nbExemplaire;
    private String nom;
    private String date;
    private boolean isAvailable;
    private Categorie cat;

    public Film(int nbExemplaire, String nom, String date, String nomCategorie, double tarif) {
        this.nbExemplaire = nbExemplaire;
        this.nom = nom;
        this.date = date;
        this.cat = new Categorie(nomCategorie, tarif);
        setDisponibilite();
    }

    private void setDisponibilite() {
        if (getNbExemplaire()>=0) isAvailable=true;
        else isAvailable=false;
    }

    public void diminueStock(){
        this.nbExemplaire -= 1;
        setDisponibilite();
    }

    public void augmenteStock(){
        this.nbExemplaire += 1;
        setDisponibilite();
    }

}
