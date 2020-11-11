import java.time.LocalDate;
import java.util.ArrayList;

public class DVDthequeTest {

    private Agence agence1;
    private Client client1;
    private Client client2;
    private Client client3;

    public static void main(String[] args) {
        new DVDthequeTest().run();
    }

    private void run() {
        init();
        ArrayList<Article> articleCommande = new ArrayList<>();
        articleCommande.add(agence1.getStock().getListarticles().get(1));
        articleCommande.add(agence1.getStock().getListarticles().get(4));
        ArrayList<Integer> dureeFilmCommande = new ArrayList<>();
        dureeFilmCommande.add(1);
        dureeFilmCommande.add(3);
        System.out.println("------------------------Client 1--------------------------------");
        client1.commande(articleCommande, dureeFilmCommande);
        System.out.println("------------------------Client 2--------------------------------");
        client2.commande(articleCommande,dureeFilmCommande);
        System.out.println("------------------------Client 3--------------------------------");
        client3.commande(articleCommande,dureeFilmCommande);

        System.out.println(Support.DVD.getTarifSupport());

        System.out.println(System.currentTimeMillis());
        LocalDate ffff = LocalDate.now() ;
        System.out.println(ffff);

    }

    public void init() {
        ArrayList<Film> filmArrayList = new ArrayList<>();
        filmArrayList.add(new Film("Iron Man","30-04-2008 12:00:00"));
        filmArrayList.add(new Film("Spider-Man New Generation","30-04-2019 12:00:00"));
        filmArrayList.add(new Film("Fast and Furious","30-05-2001 12:00:00"));
        filmArrayList.add(new Film("In the dark","30-04-2012 12:00:00"));
        filmArrayList.add(new Film("Qu'est ce qu'on a fait au bon dieu?","30-04-2013 12:00:00"));

        ArrayList<Article>articlesArrayList=new ArrayList<Article>();
        articlesArrayList.add(new Article(filmArrayList.get(0), Support.DVD, 1));
        articlesArrayList.add(new Article(filmArrayList.get(1), Support.DVD, 1));
        articlesArrayList.add(new Article(filmArrayList.get(2), Support.DVD, 3));
        articlesArrayList.add(new Article(filmArrayList.get(3), Support.DVD, 16));
        articlesArrayList.add(new Article(filmArrayList.get(4), Support.DVD, 1));

        articlesArrayList.add(new Article(filmArrayList.get(0), Support.BLU_RAY, 2));
        articlesArrayList.add(new Article(filmArrayList.get(1), Support.BLU_RAY, 0));
        articlesArrayList.add(new Article(filmArrayList.get(2), Support.BLU_RAY, 5));
        articlesArrayList.add(new Article(filmArrayList.get(3), Support.BLU_RAY, 17));
        articlesArrayList.add(new Article(filmArrayList.get(4), Support.BLU_RAY, 1));


        agence1 = new Agence(articlesArrayList);
        client1 = new Client();
        client2 = new Client();
        client3 = new Client();
    }
    //TODO : test

}