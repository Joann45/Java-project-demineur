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
        if (!super.estDecouverte()){
            symboleCase = " ";
            if (super.estMarquee()){
                symboleCase = "?";
            }
        }
        else {
            if (super.contientUneBombe()){
                symboleCase = "@";
            }
            else {
                symboleCase = ""+this.nombreBombesVoisines();
            }
        }
        return symboleCase;
    }
}
