public enum Support {
    Cassette(0.5),DVD(1.5),BLU_RAY(2.5);

    public double getTarifSupport() {
        return tarifSupport;
    }

    public void setTarifSupport(double tarifSupport) {
        this.tarifSupport = tarifSupport;
    }

    private double tarifSupport;

    Support(double v) {
        this.tarifSupport = v;
    }
}
