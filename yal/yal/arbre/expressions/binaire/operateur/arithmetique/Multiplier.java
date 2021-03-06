package yal.arbre.expressions.binaire.operateur.arithmetique;

import yal.arbre.expressions.Expression;

public class Multiplier extends ArithmetiqueBinaire {

    /**
     *
     * @param exp1
     * @param exp2
     */
    public Multiplier(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    /**
     *
     * @return
     */
    @Override
    public String toMIPS(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toMIPS());
        sb.append("    mult $v0, $t8\n");
        sb.append("    mflo $v0\n");
        return sb.toString();
    }
}
