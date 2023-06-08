package model;

public class Porto {
    private int IDENTIFICADOR;
    private String nome;
    private String pais;

    public Porto(int id, String nome, String pais) {
        this.IDENTIFICADOR = id;
        this.nome = nome;
        this.pais = pais;
    }

    public int getIDENTIFICADOR() {
        return IDENTIFICADOR;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    @Override
    public String toString() {
        return IDENTIFICADOR
                + " | Nome: " + nome
                + " | País: " + pais;
    }
}
