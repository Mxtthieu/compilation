package yal.analyse;

import yal.analyse.entre.Entree;
import yal.analyse.symbol.Symbole;
import yal.exceptions.AnalyseSemantiqueException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Bloc {

    private HashMap<Entree, Symbole> tab;
    private int idRegion;
    private Bloc blocPrecedent;
    private HashMap<Integer, Bloc> blocSuivant;

    /**
     *
     * @param idRegion
     */
    public Bloc(int idRegion) {
        this.idRegion = idRegion;
        blocPrecedent = null;
        blocSuivant = new HashMap<>();
        tab = new HashMap<>();
    }

    /**
     *
     * @param idRegion
     * @param b
     */
    public Bloc(int idRegion, Bloc b) {
        this.idRegion = idRegion;
        blocPrecedent = b;
        blocSuivant = new HashMap<>();
        tab = new HashMap<>();
    }

    /**
     *
     * @param e
     * @param s
     * @param noLigne
     */
    public void ajouter(Entree e, Symbole s, int noLigne){

        if(tab.containsKey(e)){
            throw new AnalyseSemantiqueException(noLigne,"Double déclaration");
        }
        tab.put(e,s);
    }

    /**
     *
     * @param e
     * @return
     */
    public Symbole identifier(Entree e){

        Symbole tmp = tab.get(e);

        if(tmp == null) {
            if(blocPrecedent != null) {
                tmp = blocPrecedent.identifier(e);
            }
        }
        return tmp;
    }

    /**
     *
     * @param s
     */
    public void ajouterSuivant(Bloc s) {
        Bloc b = blocSuivant.put(s.getIdRegion(), s);
    }

    /**
     *
     * @param idRegion
     * @return
     */
    public Bloc recupSuivant(int idRegion) {
        return blocSuivant.get(idRegion);
    }

    /**
     *
     * @return
     */
    public int tailleTableVariable() {
        int tmp = 0;
        for(Map.Entry<Entree, Symbole> map : tab.entrySet() ) {
            Symbole s = map.getValue();
            if(s.isVar()) {
                tmp -= 4;
            }
        }
        return tmp;
    }

    /**
     *
     * @return
     */
    public int tailleTableParam() {
        int tmp = 0;

        for(Map.Entry<Entree, Symbole> map : tab.entrySet() ) {
            Symbole s = map.getValue();

            if(s.isParam()) {

                tmp += 4;
            }
        }
        return tmp;
    }

    /**
     *
     * @return
     */
    public int getIdRegion() {
        return idRegion;
    }

    /**
     *
     * @return
     */
    public Bloc getBlocPrecedent() {
        return blocPrecedent;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return tab.toString();
    }
}