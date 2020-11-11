import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Location {
    public Article getArticle() {return article;}

    public LocalDateTime getDateRetour() {
        return dateRetour;
    }
    public double getPrix() {
        return prix;
    }
    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    private Article article;
    private LocalDateTime dateDebut;
    private LocalDateTime dateRetour;
    private double prix;


    public Location(Article article, String dateRetour) {
        this.article = article;
        this.dateDebut = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        this.dateRetour = LocalDateTime.parse(dateRetour, formatter);
        setPrix();
    }

    public void setPrix() {
        double prix = getArticle().getPrixCategorie()+getArticle().getPrixSupport();
        double somme =0.0;
        for (int i = 0; i < Math.abs(calcDureeDaysLocation(dateDebut, dateRetour)); i++) {
            somme += prix-(prix*0.1*(i));
        }
        this.prix =somme;
    }

    public long calcDureeDaysLocation(LocalDateTime debut, LocalDateTime dateRetour){
        return ChronoUnit.DAYS.between(debut, dateRetour)+1;
    }
    public long calcDureeHoursLocation(LocalDateTime debut, LocalDateTime dateRetour){
        return ChronoUnit.HALF_DAYS.between(debut, dateRetour);
    }


}
