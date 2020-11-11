import java.sql.Time;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Location {
    public Article getArticle() {return article;}

    public LocalDateTime getDateRetourPrevue() {
        return dateRetourPrevue;
    }
    public double getPrixLocation() {
        return prixLocation;
    }
    public LocalDateTime getDateDebutLocation() {
        return dateDebutLocation;
    }


    private Article article;
    private LocalDateTime dateDebutLocation;
    private LocalDateTime dateRetourPrevue;
    private double prixLocation;


    public Location(Article article, String dateRetourPrevue) {
        this.article = article;
        this.dateDebutLocation = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        this.dateRetourPrevue = LocalDateTime.parse(dateRetourPrevue, formatter);
        setPrixLocation();
    }

    private void setPrixLocation() {
        double prix = getArticle().getPrixCategorie()+getArticle().getPrixSupport() ;
        for (int i = 0; i < Math.abs(calcDureeLocation(dateDebutLocation,dateRetourPrevue)); i++) {
            prix = prix-(prix*0.1*i);
        }
        prixLocation=prix;
    }

    public long calcDureeLocation(LocalDateTime debut, LocalDateTime dateRetour){
        return ChronoUnit.HOURS.between(debut, dateRetour);

    }


}
