import java.util.ArrayList;
import java.util.List;

public class CaseIntelligente extends Case {
    private List<Case> lesVoisines;

    public CaseIntelligente(){
        this.lesVoisines = new ArrayList<>();
    }
    public void ajouteVoisine(Case uneCase){

    }
    public int nombreBombesVoisines(){
        return 1;
    }

    @Override

    public String toString(){
        return "";
    }
}
