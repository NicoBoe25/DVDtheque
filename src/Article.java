import java.util.Date;

public class Article {

    private Film film;

    private Support support;
    private int nbExemplaire;
    private boolean isAvailable;

    public Film getFilm() {
        return film;
    }
    public Support getSupport() {
        return support;
    }
    public int getNbExemplaire() {
        return nbExemplaire;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public Article(Film film, Support support, int nbExemplaire) {
        this.film = film;
        this.support = support;
        this.nbExemplaire=nbExemplaire;
        setDisponibilite();
    }


    private void setDisponibilite() {
        if (getNbExemplaire()>0) isAvailable=true;
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
    public double getPrixCategorie(){
        return getFilm().getCategorie().getTarifCat();
    }
    public double getPrixSupport(){
        return getSupport().getTarifSupport();
    }

}
