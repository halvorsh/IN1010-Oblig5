public class Labyrint {
    private Rute[][] brett;
    private int rader;
    private int kolonner;

    @Override
    public String toString() {
        String output = "";

        for(Rute[] rad : brett){
            for(Rute rute : rad){
                output += rute.charTilTegn();
            }
            output += "\n";
        }

        return output;
    }
}
