public enum Support {
    Cassette(0.5),DVD(1.5),BLU_RAY(2.5);

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    private double tarif;

    Support(double v) {
        this.tarif = v;
    }
}
