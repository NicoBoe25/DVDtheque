import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Film {

    //-------------------------Getters-----------------------------//
    public String getNom() {
        return nom;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public Categorie getCategorie(){
        return categorie;
    }
    public ArrayList<Genre> getGenreArrayList() {
        return genreArrayList;
    }

    //-------------------------Setters-----------------------------//
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setGenreArrayList(ArrayList<Genre> genreArrayList) {
        this.genreArrayList = genreArrayList;
    }


    //-------------------------Fields-----------------------------//
    private String nom;
    private LocalDateTime date;
    private Categorie categorie;
    private ArrayList<Genre> genreArrayList;

    public Film(String nom, String date, ArrayList<Genre> listGenre) {
        this.nom = nom;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        this.date=LocalDateTime.parse(date, formatter);
        this.genreArrayList = listGenre;
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
