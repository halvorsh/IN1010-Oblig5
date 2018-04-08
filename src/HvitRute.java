import java.util.ArrayList;

public class HvitRute extends Rute{
    @Override
    public void setNaboer(Rute nord, Rute ost, Rute sor, Rute vest) {
        super.setNaboer(nord, ost, sor, vest);
        settUtveier();
    }

    public ArrayList <ArrayList<Rute>> finnUtveier(String forrigeRetning) {
        ArrayList<ArrayList<Rute>> funnedeUtveier = new ArrayList <>();
        if(utveier != null){
            switch(forrigeRetning){
                case "Ingen": funnedeUtveier = utveier; System.out.println("Noe er galt, utveier skal ikke være definert."); break;
                case "Nord":
                    for(ArrayList<Rute> utvei : utveier){
                        if(utvei.get(0)!=nord){
                            funnedeUtveier.add(utvei);
                        }
                    }
                    break;
                case "Ost":
                    for(ArrayList<Rute> utvei : utveier){
                        if(utvei.get(0)!=ost){
                            funnedeUtveier.add(utvei);
                        }
                    }
                    break;
                case "Sor":
                    for(ArrayList<Rute> utvei : utveier){
                        if(utvei.get(0)!=sor){
                            funnedeUtveier.add(utvei);
                        }
                    }
                    break;
                case "Vest":
                    for(ArrayList<Rute> utvei : utveier){
                        if(utvei.get(0)!=vest){
                            funnedeUtveier.add(utvei);
                        }
                    }
                    break;
                default: System.out.println("Noe er veldig veldig galt, sjekk store bokstaver ved retning."); break;
            }
        }else{
            switch(forrigeRetning){
                case "Ingen":
                    if(nord instanceof HvitRute){
                        HvitRute hvitNord = (HvitRute) nord;
                        ArrayList<ArrayList<Rute>> nordUtveier = hvitNord.finnUtveier("Sor");

                        funnedeUtveier.addAll(nordUtveier);
                    }
                    if(ost instanceof HvitRute){
                        HvitRute hvitOst = (HvitRute) ost;
                        ArrayList<ArrayList<Rute>> ostUtveier = hvitOst.finnUtveier("Vest");

                        funnedeUtveier.addAll(ostUtveier);
                    }
                    if(sor instanceof HvitRute){
                        HvitRute hvitSor = (HvitRute) sor;
                        ArrayList<ArrayList<Rute>> sorUtveier = hvitSor.finnUtveier("Nord");

                        funnedeUtveier.addAll(sorUtveier);
                    }
                    if(vest instanceof HvitRute){
                        HvitRute hvitVest = (HvitRute) vest;
                        ArrayList<ArrayList<Rute>> vestUtveier = hvitVest.finnUtveier("Ost");

                        funnedeUtveier.addAll(vestUtveier);
                    }
                    break;
                case "Nord":
                    if(ost instanceof HvitRute){
                        HvitRute hvitOst = (HvitRute) ost;
                        ArrayList<ArrayList<Rute>> ostUtveier = hvitOst.finnUtveier("Vest");

                        funnedeUtveier.addAll(ostUtveier);
                    }
                    if(sor instanceof HvitRute){
                        HvitRute hvitSor = (HvitRute) sor;
                        ArrayList<ArrayList<Rute>> sorUtveier = hvitSor.finnUtveier("Nord");

                        funnedeUtveier.addAll(sorUtveier);
                    }
                    if(vest instanceof HvitRute){
                        HvitRute hvitVest = (HvitRute) vest;
                        ArrayList<ArrayList<Rute>> vestUtveier = hvitVest.finnUtveier("Ost");

                        funnedeUtveier.addAll(vestUtveier);
                    }
                    break;
                case "Ost":
                    if(nord instanceof HvitRute){
                        HvitRute hvitNord = (HvitRute) nord;
                        ArrayList<ArrayList<Rute>> nordUtveier = hvitNord.finnUtveier("Sor");

                        funnedeUtveier.addAll(nordUtveier);
                    }
                    if(sor instanceof HvitRute){
                        HvitRute hvitSor = (HvitRute) sor;
                        ArrayList<ArrayList<Rute>> sorUtveier = hvitSor.finnUtveier("Nord");

                        funnedeUtveier.addAll(sorUtveier);
                    }
                    if(vest instanceof HvitRute){
                        HvitRute hvitVest = (HvitRute) vest;
                        ArrayList<ArrayList<Rute>> vestUtveier = hvitVest.finnUtveier("Ost");

                        funnedeUtveier.addAll(vestUtveier);
                    }
                    break;
                case "Sor":
                    if(nord instanceof HvitRute){
                        HvitRute hvitNord = (HvitRute) nord;
                        ArrayList<ArrayList<Rute>> nordUtveier = hvitNord.finnUtveier("Sor");

                        funnedeUtveier.addAll(nordUtveier);
                    }
                    if(ost instanceof HvitRute){
                        HvitRute hvitOst = (HvitRute) ost;
                        ArrayList<ArrayList<Rute>> ostUtveier = hvitOst.finnUtveier("Vest");

                        funnedeUtveier.addAll(ostUtveier);
                    }
                    if(vest instanceof HvitRute){
                        HvitRute hvitVest = (HvitRute) vest;
                        ArrayList<ArrayList<Rute>> vestUtveier = hvitVest.finnUtveier("Ost");

                        funnedeUtveier.addAll(vestUtveier);
                    }
                    break;
                case "Vest":
                    if(nord instanceof HvitRute){
                        HvitRute hvitNord = (HvitRute) nord;
                        ArrayList<ArrayList<Rute>> nordUtveier = hvitNord.finnUtveier("Sor");

                        funnedeUtveier.addAll(nordUtveier);
                    }
                    if(ost instanceof HvitRute){
                        HvitRute hvitOst = (HvitRute) ost;
                        ArrayList<ArrayList<Rute>> ostUtveier = hvitOst.finnUtveier("Vest");

                        funnedeUtveier.addAll(ostUtveier);
                    }
                    if(sor instanceof HvitRute){
                        HvitRute hvitSor = (HvitRute) sor;
                        ArrayList<ArrayList<Rute>> sorUtveier = hvitSor.finnUtveier("Nord");

                        funnedeUtveier.addAll(sorUtveier);
                    }
                    break;
                default: System.out.println("Error med pathfinding");
            }
        }

        if(this instanceof Aapning){
            funnedeUtveier.add(new ArrayList <>());
        }

        if(funnedeUtveier.size() == 0){
            funnedeUtveier = null;
        }else{
            for(ArrayList<Rute> utvei : funnedeUtveier){
                utvei.add(0, this);
            }
        }
        return funnedeUtveier;
    }

    public void settUtveier() {
        utveier = finnUtveier("Ingen");
    }

    @Override
    public String charTilTegn() {
        return ".";
    }
}
