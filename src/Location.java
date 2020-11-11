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

    private Article article;
    private Date dateDebutLocation;
    private Date dateRetourPrevue;
    private double prixLocation;


    public Location(Article article, String dateRetourPrevue) {
        this.article = article;
        this.dateDebutLocation = new Date();
        this.dateRetourPrevue = new Date(String.valueOf(dateRetourPrevue));
        setPrixLocation();
    }

    private void setPrixLocation() {
        double prix = getArticle().getPrixCategorie()+getArticle().getPrixSupport() ;
        for (int i = 0; i < calcDureeLocation(getDateRetourPrevue()); i++) {
            prix = prix-(prix*0.1*i);
        }
        prixLocation=prix;
    }

    public long calcDureeLocation(Date dateRetour){
        long diffdates=dateDebutLocation.getTime()-dateRetour.getTime();
        return TimeUnit.DAYS.convert(diffdates, TimeUnit.HOURS);
    }


}
