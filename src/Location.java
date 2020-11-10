public class Location {
    public Article getArticle() {return article;}

    public int getDuree() {
        return duree;
    }
    public String getDateRetourPrevue() {
        return dateRetourPrevue;
    }
    public double getPrixLocation() {
        return prixLocation;
    }

    private Article article;
    private int duree;
    private String dateRetourPrevue;
    private double prixLocation;


    public Location(Article article, int duree, String dateRetourPrevue) {
        this.article = article;
        this.duree = duree;
        this.dateRetourPrevue = dateRetourPrevue;
        setPrixLocation(duree);
    }

    private void setPrixLocation(int duree) {
        double prix = getArticle().getPrixCategorie()+getArticle().getPrixSupport() ;
        for (int i = 0; i < getDuree(); i++) {
            prix = prix-(prix*0.1*i);
        }
        prixLocation=prix;
    }


}
