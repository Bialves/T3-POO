package model;

public class Perecivel extends TipoCarga {
    private String origem;
    private int validadeMax;

    public Perecivel(int numero, String o, int val, String desc) {
        super(numero, desc);
        this.origem = o;
        this.validadeMax = val;
    }

    @Override
    public String toString() {
        return getNumero()
                + " | Origem: " + origem
                + " | Validade máxima: " + validadeMax
                + " | Descrição: " + getDescricao();
    }
}

