import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    private boolean isAvailable;

    public Film(int nbExemplaire, String nom, String date ) {
        this.nbExemplaire = nbExemplaire;
        this.nom = nom;
        setDisponibilite();

        setNewDate(date);
    }

    private void setNewDate(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date1 = simpleDateFormat.parse(date) ;
            this.date = date1 ;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //setCategorie();

    }

    /*
    private void setCategorie() {
        if (date.compareTo(new Date())){

        }
    }
    */



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
