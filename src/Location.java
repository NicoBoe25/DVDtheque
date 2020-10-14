public class Location {
    public Film getFilm() {        return film;    }

    public int getDuree() {
        return duree;
    }

    public String getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    private Film film;
    private int duree;
    private String dateRetourPrevue;


    public Location(Film film, int duree, String dateRetourPrevue) {
        this.film = film;
        this.duree = duree;
        this.dateRetourPrevue = dateRetourPrevue;
    }
}
