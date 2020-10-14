import java.util.ArrayList;

public class Client {

    public ArrayList<Location> getLocationArrayList() {
        return locationArrayList;
    }

    private ArrayList<Location> locationArrayList;

    public Client() {
        this.locationArrayList = new ArrayList<>();
    }

    public void commande(ArrayList<Film> filmArrayListLocation, ArrayList<Integer> dureeArrayListLocation){
        boolean locationIsOK = true;
        ArrayList<Location> locationsTemp = new ArrayList<Location>();
        for (int i = 0; i < filmArrayListLocation.size(); i++) {
            if (filmArrayListLocation.get(i).isAvailable()) {
                Location loc = new Location(filmArrayListLocation.get(i), dureeArrayListLocation.get(i), "01-01-2021");
                locationsTemp.add(loc);
                loc.getFilm().diminueStock();
            } else {
                locationIsOK = false;
                System.out.println("Le film "+filmArrayListLocation.get(i).getNom()+" n'est pas disponible");
            }
        }
        if (locationIsOK){
            System.out.println("Tous les films ont été loué");
        }
        facture(locationsTemp);
    }

    public void facture(ArrayList<Location> locations){
        double somme = 0;
        for (Location f: locations) {
            somme += f.getFilm().getCat().getTarif();
        }
    }

    public void penalise(){}
    public void renduLocation(){}
}
