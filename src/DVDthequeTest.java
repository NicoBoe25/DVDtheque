import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class DVDthequeTest {

    private Agence agence1;
    private Client client1;
    private Client client2;
    private Client client3;
    private Client client4;

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
        Facture facture1 = client1.commande(articleCommande, dureeFilmCommande);

        System.out.println("------------------------Client 2--------------------------------");
        Facture facture2 = client2.commande(articleCommande,dureeFilmCommande);

        System.out.println("------------------------Client 3--------------------------------");
        Facture facture3 = client3.commande(articleCommande,dureeFilmCommande);

        System.out.println(Support.DVD.getTarifSupport());

    }

    public void init() {
        ArrayList<Genre> genres = new ArrayList<>();
        genres.add(Genre.ACTION);
        genres.add(Genre.SUPERHEROS);
        ArrayList<Film> filmArrayList = new ArrayList<>();
        filmArrayList.add(new Film("Iron Man","2008/04/30 12:00:00",genres));
        genres.clear();
        genres.add(Genre.ACTION);
        genres.add(Genre.SUPERHEROS);
        genres.add(Genre.ANIMATION);
        genres.add(Genre.SUPERHEROS);
        filmArrayList.add(new Film("Spider-Man New Generation","2019/04/30 12:00:00",genres));
        genres.clear();
        genres.add(Genre.ACTION);
        genres.add(Genre.THRILLER);
        genres.add(Genre.AVENTURE);
        filmArrayList.add(new Film("Fast and Furious","2001/05/30 12:00:00",genres));
        genres.clear();
        genres.add(Genre.HORREUR);
        genres.add(Genre.THRILLER);
        genres.add(Genre.SUSPENS);
        filmArrayList.add(new Film("In the dark","2012/04/30 12:00:00",genres));
        genres.clear();
        genres.add(Genre.COMEDIE);
        filmArrayList.add(new Film("Qu'est ce qu'on a fait au bon dieu?","2013/04/30 12:00:00",genres));
        genres.clear();
        genres.add(Genre.DRAME);
        genres.add(Genre.ACTION);
        genres.add(Genre.AVENTURE);
        filmArrayList.add(new Film("Le Mans 66","2019/08/30 12:00:00",genres));

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
        client1 = new Client("Peter", "Parker",new Date("2000/11/11"),agence1);
        client2 = new Client("Miles","Morales",new Date("2004/01/01"),agence1);
        client3 = new Client("Harry", "Osborn",new Date("1985/09/06"),agence1);
        client4 = new Client("Gwen", "Stacy",new Date("2000/09/06"),agence1);
    }
    //TODO : test

}