import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


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
        double prix = getArticle().getPrixCategorie()+getArticle().getPrixSupport();
        double somme =0.0;
        for (int i = 0; i < Math.abs(calcDureeDaysLocation(dateDebutLocation,dateRetourPrevue)); i++) {
            somme += prix-(prix*0.1*(i));
        }
        prixLocation=somme;
    }

    public long calcDureeDaysLocation(LocalDateTime debut, LocalDateTime dateRetour){
        return ChronoUnit.DAYS.between(debut, dateRetour)+1;
    }
    public long calcDureeHoursLocation(LocalDateTime debut, LocalDateTime dateRetour){
        return ChronoUnit.HALF_DAYS.between(debut, dateRetour);
    }


}
