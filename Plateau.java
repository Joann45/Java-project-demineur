import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Plateau{

    private int nbLignes;
    private int nbColonnes;
    private int pourcentageDeBombes;
    private int nbBombes;
    private List<List<CaseIntelligente>> lePlateau;

    public Plateau(int nbLignes, int nbColonnes, int pourcentageDeBombes){
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.pourcentageDeBombes = pourcentageDeBombes;
        this.nbBombes = nbLignes*nbColonnes*pourcentageDeBombes/100;
        this.lePlateau = new ArrayList<>();
    }

    public CaseIntelligente getCase(int numLigne, int numColonne) throws IndexOutOfBoundsException{
        return this.lePlateau.get(numLigne).get(numColonne);
    }

    private void creerLesCasesVides(){
        List<CaseIntelligente> uneLigne = new ArrayList<>();
        for (int i = 0; i < this.nbLignes; i++){
            uneLigne.clear();
            for (int j = 0; j < this.nbColonnes; j++) {
                uneLigne.add(new CaseIntelligente());
            }
            this.lePlateau.add(uneLigne);
        }

    }
    private void rendLesCasesIntelligentesArrêtes(int i, int j){
        if (i == 0){
            if (j == 0){
                getCase(i, j).ajouteVoisine(getCase(i, j+1));
                getCase(i, j).ajouteVoisine(getCase(i+1, j));
                System.exit(0);
            }
            getCase(i, j).ajouteVoisine(getCase(i, j+1));
            getCase(i, j).ajouteVoisine(getCase(i+1, j));
            getCase(i, j).ajouteVoisine(getCase(i, j-1));
            System.exit(0);
        }
    }

    private void rendLesCasesIntelligentes(){
        for (int i = 0; i < this.lePlateau.size(); i++){
            for (int j = 1; j < this.lePlateau.get(0).size(); i++){
                
            }
        }
    }
    protected void poseDesBombesAleatoirement(){
        Random generateur = new Random();
        for (int x = 0; x < this.getNbLignes(); x++){
            for (int y = 0; y < this.getNbColonnes(); y++){
                if (generateur.nextInt(100)+1 < this.pourcentageDeBombes){
                    this.poseBombe(x, y);
                    this.nbBombes = this.nbBombes + 1;
                }
            }
        }
    }
    public int getNbLignes(){
        return 1;
    }
    public int getNbColonnes(){
        return 1;
    }
    public int getNbTotalBombes(){
        return 1;
    }

    public int getNbCasesMarquees(){
        int n = 0;
        for (int i = 0; i<this.getNbLignes(); i ++){
            for (int j = 0; j < this.getNbColonnes(); j++){
                if (this.getCase(i, j).estMarquee()){
                    n += 1;
                }
            }
        }
        return n;
    }

    public void poseBombe(int x, int y){
        this.getCase(x, y).poseBombe();
    }

    public void reset(){
        this.nbBombes = 0;
        for (int i = 0; i<this.getNbLignes(); i ++){
            for (int j = 0; j < this.getNbColonnes(); j++){
                this.getCase(i, j).reset();
            }
        }
    }

}
