package yal.arbre.expressions.binaire.operateur.comparaison;

import yal.arbre.expressions.Expression;

public class Egalite extends Comparaison {

    /**
     *
     * @param exp1
     * @param exp2
     */
    public Egalite(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    /**
     *
     * @return
     */
    @Override
    public String toMIPS() {
        StringBuilder sb = new StringBuilder();
        sb.append("    # Egalité\n");
        sb.append(super.toMIPS());
        sb.append("    seq $v0, $t8, $v0\n");
        return sb.toString();
    }


}
