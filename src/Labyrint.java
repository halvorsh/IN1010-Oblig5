import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Labyrint {
    private Rute[][] brett;
    private int rader;
    private int kolonner;

    private Labyrint(Rute[][] brett, int rader, int kolonner){
        this.brett = brett;
        this.rader = rader;
        this.kolonner = kolonner;
    }

    static Labyrint lesFraFil(File fil) throws FileNotFoundException {
        Scanner scanner = new Scanner(fil);
        ArrayList<Rute[]> lageBrett = new ArrayList <>();
        int rader = 0;
        int kolonner = 0;

        while(scanner.hasNextLine()){
            ArrayList<Rute> lageRad = new ArrayList <>();
            String linje = scanner.nextLine();
            String[] biter = linje.split("");

            kolonner = biter.length;
            Rute[] rad;

            for(String bit : biter){
                Rute rute;
                if(bit == "."){
                    rute = new HvitRute();
                }else if(bit == "#"){
                    rute = new SortRute();
                }else{
                    System.out.println("Feil ved filInnlesning");
                    break;
                }
                lageRad.add(rute);
            }
            rad = (Rute[]) lageRad.toArray();
            rader++;
            lageBrett.add(rad);
        }

        Rute[][] brett = (Rute[][]) lageBrett.toArray();

        for(int i = 0; i < brett.length; i++){
            for(int j = 0; j < brett[i].length; i++){
                Rute gjeldeneRute = brett[i][j];

                Rute nord, ost, vest, sor;

                if(i==0){
                    nord = null;
                    sor = brett[i+1][j];
                }else if(i==rader){
                    sor = null;
                    nord = brett[i-1][j];
                }else{
                    nord = brett[i-1][j];
                    sor = brett[i+1][j];
                }

                if(j==0){
                    ost = null;
                    vest = brett[i][j+1];
                }else if(j==kolonner){
                    vest = null;
                    ost = brett[i][j-1];
                }else{
                    ost = brett[i][j-1];
                    vest = brett[i][j+1];
                }

                gjeldeneRute.setNaboer(nord, ost, sor, vest);
            }
        }

        return new Labyrint(brett, rader, kolonner);
    }

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
