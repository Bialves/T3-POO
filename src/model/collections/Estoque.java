package model.collections;

import model.Carga;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Carga> estoque;

    public Estoque() {
        estoque = new ArrayList<>();
    }

    public ArrayList<Carga> getEstoque() {
        return estoque;
    }

    public boolean adicionarCarga(Carga carga) {
        if (!consulta(carga.getIDENTIFICADOR())) {
            return estoque.add(carga);
        }
        return false;
    }

    public boolean consulta(int id) {
        for (Carga carga : estoque) {
            if (carga.getIDENTIFICADOR() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sc = new StringBuilder();
        for (Carga carga : estoque) {
            sc.append(carga.toString());
            sc.append("\n");
        }
        return sc.toString();
    }
}
