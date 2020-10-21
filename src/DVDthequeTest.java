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
        ArrayList<Film> filmsCommande = new ArrayList<>();
        filmsCommande.add(agence1.getStock().getListFilm().get(1));
        filmsCommande.add(agence1.getStock().getListFilm().get(4));
        ArrayList<Integer> dureeFilmCommande = new ArrayList<>();
        dureeFilmCommande.add(1);
        dureeFilmCommande.add(3);
        System.out.println("------------------------Client 1--------------------------------");
        client1.commande(filmsCommande, dureeFilmCommande);
        System.out.println("------------------------Client 2--------------------------------");
        client2.commande(filmsCommande,dureeFilmCommande);
        System.out.println("------------------------Client 3--------------------------------");
        client3.commande(filmsCommande,dureeFilmCommande);
    }

    public void init() {
        ArrayList<Film> filmArrayList = new ArrayList<>();
        filmArrayList.add(new Film(3,"Iron Man","30-04-2008","Ancien",6.99));
        filmArrayList.add(new Film(1,"Spider-Man New Generation","30-04-2019","An passé",9.99));
        filmArrayList.add(new Film(5,"Fast and Furious","30-05-2001","Ancien",3.99));
        filmArrayList.add(new Film(33,"In the dark","30-04-2012","Ancien",4.99));
        filmArrayList.add(new Film(2,"Qu'est ce qu'on a fait au bon dieu?","30-04-2013","Ancien",1.99));
        agence1 = new Agence(filmArrayList);
        client1 = new Client();
        client2 = new Client();
        client3 = new Client();
    }
}
