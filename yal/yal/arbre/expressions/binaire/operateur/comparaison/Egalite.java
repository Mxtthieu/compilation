package yal.arbre.expressions.binaire.operateur.comparaison;

import yal.arbre.expressions.Expression;
import yal.arbre.expressions.binaire.Binaire;
import yal.exceptions.AnalyseSemantiqueException;

public class Egalite extends Comparaison {

    private Expression gauche;
    private Expression droite;

    public Egalite(Expression exp1, Expression exp2) {
        super(exp1, exp2);
        gauche = exp1;
        droite = exp2;
    }

    @Override
    public void verifier(){
        super.verifier();
    }

    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        sb.append("    # Egalité\n");
        sb.append(super.toMIPS());
        sb.append("    seq $v0, $t8, $v0\n");
        return sb.toString();
    }

    @Override
    public String getType() {
        return "bool";
    }

    public Expression getGauche() {
        return gauche;
    }

    public Expression getDroite() {
        return droite;
    }
}
