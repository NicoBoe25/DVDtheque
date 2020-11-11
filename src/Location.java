import java.sql.Time;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Location {
    public Article getArticle() {return article;}

    public Date getDateRetourPrevue() {
        return dateRetourPrevue;
    }
    public double getPrixLocation() {
        return prixLocation;
    }
    public Date getDateDebutLocation() {
        return dateDebutLocation;
    }


    private Article article;
    private Date dateDebutLocation;
    private Date dateRetourPrevue;
    private double prixLocation;


    public Location(Article article, String dateRetourPrevue) {
        this.article = article;
        this.dateDebutLocation = new Date();
        this.dateRetourPrevue = new Date(dateRetourPrevue);
        setPrixLocation();
    }

    private void setPrixLocation() {
        double prix = getArticle().getPrixCategorie()+getArticle().getPrixSupport() ;
        for (int i = 0; i < Math.abs(calcDureeLocation(dateDebutLocation,dateRetourPrevue)); i++) {
            prix = prix-(prix*0.1*i);
        }
        prixLocation=prix;
    }

    public long calcDureeLocation(Date debut, Date dateRetour){
        long diffdates=dateRetour.getTime()-debut.getTime();
        return TimeUnit.DAYS.convert(diffdates, TimeUnit.HOURS);
    }


}
