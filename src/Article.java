public class Article {

    private Film film;

    private Support support;
    private int nbExemplaires;
    private boolean isAvailable;

    public Film getFilm() {
        return film;
    }
    public Support getSupport() {
        return support;
    }
    public int getNbExemplaires() {
        return nbExemplaires;
    }
    public boolean isAvailable() {
        return isAvailable;
    }

    public Article(Film film, Support support, int nbExemplaires) {
        this.film = film;
        this.support = support;
        this.nbExemplaires = nbExemplaires;
        setDisponibilite();
    }


    private void setDisponibilite() {
        if (getNbExemplaires()>0) isAvailable=true;
        else isAvailable=false;
    }

    public void diminueStock(){
        this.nbExemplaires -= 1;
        setDisponibilite();
    }

    public void augmenteStock(){
        this.nbExemplaires += 1;
        setDisponibilite();
    }
    public double getPrixCategorie(){
        return getFilm().getCategorie().getTarif();
    }
    public double getPrixSupport(){
        return getSupport().getTarif();
    }

}
