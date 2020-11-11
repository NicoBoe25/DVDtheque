import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Film {

    //-------------------------Getters-----------------------------//
    public String getNom() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public Categorie getCategorie(){
        return categorie;
    }


    //-------------------------Setters-----------------------------//
    public void setNom(String nom) {
        this.nom = nom;
    }



    //-------------------------Fields-----------------------------//
    private String nom;
    private Date date;
    private Categorie categorie;

    public Film(String nom, String date ) {
        this.nom = nom;
        this.date=new Date(date);
        setCategorie();
    }


    private void setCategorie() {
        Date dateNow = new Date();
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
