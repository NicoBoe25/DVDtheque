public class Location {
    public Article getArticle() {return article;}

    public int getDuree() {
        return duree;
    }

    public String getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    private Article article;
    private int duree;
    private String dateRetourPrevue;


    public Location(Article article, int duree, String dateRetourPrevue) {
        this.article = article;
        this.duree = duree;
        this.dateRetourPrevue = dateRetourPrevue;
    }
}
