package yal.analyse.symbol;

public class SymboleEntier extends Symbole {


    public SymboleEntier(String t) {
        super(t);
    }

    @Override
    public String getType() {
        return "entier";
    }
}