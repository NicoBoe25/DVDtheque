import java.util.ArrayList;

public class DVDthequeTest {

    private Agence agence1;
    private Client client1;
    private Client client2;
    private Client client3;
    private Client client4;
    private Client client5;

    public static void main(String[] args) {
        new DVDthequeTest().run();
    }

    private void run() {
        init();
        ArrayList<Article> articleCommande = new ArrayList<>();
        articleCommande.add(agence1.getStock().getArticles().get(1));
        articleCommande.add(agence1.getStock().getArticles().get(4));
        ArrayList<String> dureeFilmCommande = new ArrayList<>();
        dureeFilmCommande.add("2020/11/12 12:00");
        dureeFilmCommande.add("2020/11/14 12:00");

        ArrayList<Article> articleClient4ArrayList = new ArrayList<>();
        articleClient4ArrayList.add(agence1.getStock().getArticles().get(0));
        articleClient4ArrayList.add(agence1.getStock().getArticles().get(2));
        articleClient4ArrayList.add(agence1.getStock().getArticles().get(3));
        articleClient4ArrayList.add(agence1.getStock().getArticles().get(5));
        articleClient4ArrayList.add(agence1.getStock().getArticles().get(6));
        ArrayList<String> dureeFilmClint4 = new ArrayList<>();
        dureeFilmClint4.add("2020/11/12 12:00");
        dureeFilmClint4.add("2020/11/13 12:00");
        dureeFilmClint4.add("2020/11/12 12:00");
        dureeFilmClint4.add("2020/11/14 12:00");
        dureeFilmClint4.add("2020/11/14 12:00");


        System.out.println("------------------------Client 1--------------------------------");
        Facture facture1 = client1.commander(articleCommande, dureeFilmCommande);
        System.out.println("Le montant de votre facture s'élève à "+facture1.getMontant());
        client1.payer(facture1,MoyenPaiement.CB);

        for (Location l:client1.getLocations()) {
            client1.rendreLocation(l);
        }

        System.out.println("------------------------Client 2--------------------------------");
        Facture facture2 = client2.commander(articleCommande,dureeFilmCommande);
        System.out.println("Le montant de votre facture s'élève à "+facture2.getMontant());
        client2.payer(facture2,MoyenPaiement.ESPECE);


        System.out.println("------------------------Client 3--------------------------------");
        Facture facture3 = client3.commander(articleCommande,dureeFilmCommande);
        System.out.println("Le montant de votre facture s'élève à "+facture3.getMontant());
        client3.payer(facture3,MoyenPaiement.CHEQUE);

        System.out.println("------------------------Client 4--------------------------------");
        Facture facture4 = client4.commander(articleClient4ArrayList,dureeFilmClint4);
        System.out.println("Le montant de votre facture s'élève à "+facture4.getMontant());
        client4.payer(facture4,MoyenPaiement.COMPTE);

        for (Location l:client4.getLocations()) {
            System.out.println("--------------Rend Article-----------------");
            client4.rendreLocation(l);
        }


        System.out.println("");
        System.out.println("----------------Test de solde negatif du compte");
        client4.getCompte().debiter(90);
        System.out.println("------------------------Client 4--------------------------------");
        Facture facture5 = client4.commander(articleClient4ArrayList,dureeFilmClint4);
        System.out.println("Le montant de votre facture s'élève à "+facture5.getMontant());
        client4.payer(facture5,MoyenPaiement.COMPTE);

        System.out.println("------------------------Client 5 Réservation--------------------------");
        client5.reserver(agence1.getStock().getArticles().get(3),"2020/11/14 12:00");
        System.out.println(client5.getReservations().get(0).getArticle().getFilm().getTitre());




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
        genres.clear();
        genres.add(Genre.COMEDIE);
        genres.add(Genre.ACTION);
        filmArrayList.add(new Film("30 Jours Max","2020/10/14 12:00:00",genres));

        ArrayList<Article>articlesArrayList=new ArrayList<Article>();
        articlesArrayList.add(new Article(filmArrayList.get(0), Support.DVD, 1));
        articlesArrayList.add(new Article(filmArrayList.get(1), Support.DVD, 2));
        articlesArrayList.add(new Article(filmArrayList.get(2), Support.DVD, 3));
        articlesArrayList.add(new Article(filmArrayList.get(3), Support.DVD, 16));
        articlesArrayList.add(new Article(filmArrayList.get(4), Support.DVD, 1));
        articlesArrayList.add(new Article(filmArrayList.get(5), Support.DVD, 10));
        articlesArrayList.add(new Article(filmArrayList.get(6), Support.DVD, 2));

        articlesArrayList.add(new Article(filmArrayList.get(0), Support.BLU_RAY, 2));
        articlesArrayList.add(new Article(filmArrayList.get(1), Support.BLU_RAY, 0));
        articlesArrayList.add(new Article(filmArrayList.get(2), Support.BLU_RAY, 5));
        articlesArrayList.add(new Article(filmArrayList.get(3), Support.BLU_RAY, 17));
        articlesArrayList.add(new Article(filmArrayList.get(4), Support.BLU_RAY, 1));
        articlesArrayList.add(new Article(filmArrayList.get(5), Support.BLU_RAY, 5));
        articlesArrayList.add(new Article(filmArrayList.get(5), Support.BLU_RAY, 5));


        agence1 = new Agence(articlesArrayList);

        client1 = new Client("Peter", "Parker","2000/11/11 12:00:00",agence1);
        client2 = new Client("Miles","Morales","2004/01/01 12:00:00",agence1);
        client3 = new Client("Harry", "Osborn","1985/09/06 12:00:00",agence1);
        client4 = new Client("Gwen", "Stacy","2000/09/06 12:00:00",agence1);
        client4.creerCompte();
        client4.getCompte().credite(100);
        client5 = new Client("Curtis", "Connors","1978/04/25 12:00:00",agence1);

    }
}