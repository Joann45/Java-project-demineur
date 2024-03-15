import java.util.ArrayList;
import java.util.List;

public class CaseIntelligente extends Case {
    private List<Case> lesVoisines;

    public CaseIntelligente(){
        super();
        this.lesVoisines = new ArrayList<>();
    }
    public void ajouteVoisine(Case uneCase){
        this.lesVoisines.add(uneCase);
    }
    public int nombreBombesVoisines(){
        int nbBombes = 0;
        for (Case uneCase : this.lesVoisines){
            if (uneCase.contientUneBombe()){
                nbBombes += 1;
            }
        }
        return nbBombes;
    }

    @Override

    public String toString(){
        String symboleCase = "";
        if (!this.estDecouverte()){
            symboleCase = " ";
            if (this.estMarquee()){
                symboleCase = "?";
            }
        }
        else {
            if (this.contientUneBombe()){
                symboleCase = "@";
            }
            else {
                symboleCase = ""+this.nombreBombesVoisines();
            }
        }
        return symboleCase;
    }
}
