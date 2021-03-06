package yal.arbre.expressions.binaire.operateur.logique;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.binaire.Binaire;
import yal.exceptions.AnalyseSemantiqueException;

public class Logique extends Binaire {

    private Expression gauche;
    private Expression droite;

    /**
     *
     * @param exp1
     * @param exp2
     */
    public Logique(Expression exp1, Expression exp2) {
        super(exp1, exp2);
        gauche = exp1;
        droite = exp2;

    }

    /**
     *
     * @throws AnalyseSemantiqueException
     */
    @Override
    public void verifier()throws AnalyseSemantiqueException{
        StringBuilder sb = new StringBuilder();
        if(gauche.getType().equals("entier") && droite.getType().equals("entier")) {
            sb.append("Erreur de type : l'operande de gauche et droite sont de type entier ");
            throw new AnalyseSemantiqueException(getNoLigne(),sb.toString());

        }else if(gauche.getType().equals("entier")) {
            sb.append("Erreur de type : l'operande de gauche est de type entier ");
            throw new AnalyseSemantiqueException(getNoLigne(),sb.toString());

        }else if(droite.getType().equals("entier")){
            sb.append("Erreur de type : l'operande de droite est de type antier ");
            throw new AnalyseSemantiqueException(getNoLigne(),sb.toString());
        }

    }

    /**
     *
     * @return
     */
    @Override
    public String toMIPS() {
        return super.toMIPS();
    }

    /**
     *
     * @return
     */
    @Override
    public String getType() {
        return "bool";
    }

    @Override
    public boolean isConstante() {
        return false;
    }
}
