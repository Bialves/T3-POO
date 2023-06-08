package model.collections;

import model.Porto;
import java.util.ArrayList;

public class Navegacao {
    private ArrayList<Porto> navegacoes;

    public Navegacao() {
        navegacoes = new ArrayList<>();
    }

    public ArrayList<Porto> getNavegacoes() {
        return navegacoes;
    }

    public boolean adicionarPorto(Porto porto) {
        if (consulta(porto.getIDENTIFICADOR()) == null) {
            return navegacoes.add(porto);
        }
        return false;
    }

    public Porto consulta(int id) {
        for (Porto porto : navegacoes) {
            if (porto.getIDENTIFICADOR() == id) {
                return porto;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sc = new StringBuilder();
        for (Porto porto : navegacoes) {
            sc.append(porto.toString());
            sc.append("\n");
        }
        return sc.toString();
    }
}
