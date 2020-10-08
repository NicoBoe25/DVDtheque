public class Location {
    private Film film;
    private int duree;
    private String dateRetourPrevue;


    public Location(Film film, int duree, String dateRetourPrevue) {
        this.film = film;
        this.duree = duree;
        this.dateRetourPrevue = dateRetourPrevue;
    }
}
