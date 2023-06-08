package model;

public class Carga {
    private final int IDENTIFICADOR;
    private TipoCarga tipoCarga;
    private Cliente cliente;
    private Porto origem;
    private Porto destino;
    private int peso; // em Kg
    private double valorDeclarado;
    private int tempoMaximo; // em dias

    public Carga(int id, TipoCarga t, Cliente c, Porto o, Porto d, int p, double val, int tempo) {
        this.IDENTIFICADOR = id;
        this.tipoCarga = t;
        this.cliente = c;
        this.peso = p;
        this.valorDeclarado = val;
        this.tempoMaximo = tempo;
        this.origem = o;
        this.destino = d;
    }

    public int getIDENTIFICADOR() {
        return IDENTIFICADOR;
    }

    public TipoCarga getTipoCarga() {
        return tipoCarga;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Porto getOrigem() {
        return origem;
    }

    public Porto getDestino() {
        return destino;
    }

    public int getPeso() {
        return peso;
    }

    public double getValorDeclarado() {
        return valorDeclarado;
    }

    public int getTempoMaximo() {
        return tempoMaximo;
    }

    public String toString() {
        return "ID: " + IDENTIFICADOR
                + "\n" + "Cliente ID: " + cliente.toString()
                + "\n" + "Tipo número: " + tipoCarga.toString()
                + "\n" + "Peso: " + peso
                + " | Tempo máximo: " + tempoMaximo
                + " | Valor declarado: " +valorDeclarado
                + "\n" + "Porto origem ID: " + origem.toString()
                + "\n" + "Porto destino ID: " + destino.toString();
    }
}
