import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Film {

    //-------------------------Getters-----------------------------//
    public int getNbExemplaire() {
        return nbExemplaire;
    }

    public String getNom() {
        return nom;
    }

    public Date getDate() {
        return date;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    //-------------------------Setters-----------------------------//
    public void setNom(String nom) {
        this.nom = nom;
    }



    //-------------------------Fields-----------------------------//
    private int nbExemplaire;
    private String nom;
    private Date date;
    private Categorie categorie;
    private boolean isAvailable;

    public Film(int nbExemplaire, String nom, String date ) {
        this.nbExemplaire = nbExemplaire;
        this.nom = nom;
        this.date=new Date(date);
        setDisponibilite();
        setCategorie();
    }


    private void setCategorie() {
        LocalDate date = LocalDate.now(); // Gets the current date
        Date dateNow = new Date(String.valueOf(date));
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
}
