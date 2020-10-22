import java.util.ArrayList;
import java.util.Scanner;

public class Stock {

    public ArrayList<Film> getListFilm() {
        return listFilm;
    }

    private ArrayList<Film> listFilm;

    public Stock() {
        init();
    }

    public Stock(ArrayList<Film> listFilm){
        this.listFilm = listFilm;
    }

    private void init() {
        System.out.println("Combien de films avez vous dans votre stock ?");
        Scanner scanner = new Scanner(System.in);
        int nbFilm = scanner.nextInt();
        for (int i = 0; i < nbFilm; i++) {
            System.out.println("Nom du film :");
            String nomFilm = scanner.nextLine();
            System.out.println("Date de sortie :");
            String dateFilm = scanner.nextLine();
            System.out.println("Nombre d'Exemplaire :");
            int nbExemplaire = scanner.nextInt();

            listFilm.add(new Film(nbExemplaire,nomFilm,dateFilm));
        }
    }
}
