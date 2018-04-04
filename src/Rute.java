public abstract class Rute {
    private int radPosisjon;
    private int kolonnePosisjon;

    private Rute nord;
    private Rute ost;
    private Rute sor;
    private Rute vest;

    public void setNaboer(Rute nord, Rute ost, Rute sor, Rute vest){
        this.nord = nord;
        this.ost = ost;
        this.sor = sor;
        this.vest = vest;
    }

    public int getRadPosisjon() {
        return radPosisjon;
    }

    public int getKolonnePosisjon() {
        return kolonnePosisjon;
    }

    public Rute getNord() {
        return nord;
    }

    public Rute getOst() {
        return ost;
    }

    public Rute getSor() {
        return sor;
    }

    public Rute getVest() {
        return vest;
    }

    public abstract String charTilTegn();
}
