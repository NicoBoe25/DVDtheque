import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Film {

    //-------------------------Getters-----------------------------//
    public String getTitre() {
        return titre;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public Categorie getCategorie(){
        return categorie;
    }
    public ArrayList<Genre> getGenres() {
        return genres;
    }

    //-------------------------Setters-----------------------------//
    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }


    //-------------------------Fields-----------------------------//
    private String titre;
    private LocalDateTime date;
    private Categorie categorie;
    private ArrayList<Genre> genres;

    public Film(String titre, String date, ArrayList<Genre> listGenre) {
        this.titre = titre;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.date=LocalDateTime.parse(date, formatter);
        this.genres = listGenre;
        setCategorie();
    }


    private void setCategorie() {
        LocalDateTime dateNow = LocalDateTime.now();
        if (getDate().compareTo(dateNow)==0){
            this.categorie= Categorie.NOUVEAUTE;
        }else if (getDate().getYear()==dateNow.getYear()){
            if (getDate().getMonth()==dateNow.getMonth()){
                this.categorie=Categorie.RECENT;
            }else {
                this.categorie=Categorie.ANNEE;
            }
        }else if (getDate().getYear()==dateNow.getYear()-1){
            this.categorie=Categorie.AN_PASSE;
        }else {
            this.categorie=Categorie.ANCIEN;
        }
    }

}
