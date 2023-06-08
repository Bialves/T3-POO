package model;

public class Cliente {
    private int IDENTIFICADOR;
    private String nome;
    private String email;

    public Cliente(int id, String nome, String email) {
        this.IDENTIFICADOR = id;
        this.nome = nome;
        this.email = email;
    }

    public int getIDENTIFICADOR() {
        return IDENTIFICADOR;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return IDENTIFICADOR
                + " | Nome: " + nome
                + " | Email: " + email;
    }
}
