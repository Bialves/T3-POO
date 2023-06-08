package model;

public class Duravel extends TipoCarga {
    private String setor;
    private String material;
    private double impostoIndustrializado;

    public Duravel(int numero, String s, String m, double i, String desc) {
        super(numero, desc);
        this.setor = s;
        this.material = m;
        this.impostoIndustrializado = i;
    }

    @Override
    public String toString() {
        return getNumero()
                + " | Setor: " + setor
                + " | Material principal: " + material
                + " | Imposto IPI: " + impostoIndustrializado
                + " | Descrição: " + getDescricao();
    }
}
