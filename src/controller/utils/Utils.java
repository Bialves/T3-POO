package controller.utils;

import model.*;
import model.collections.*;
import view.Screen;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.Comparator;

public class Utils {
    // Inner class para reordenação da lista
    class OrderEstoque implements Comparator<Carga> {
        @Override
        public int compare(Carga cargaOne, Carga cargaSecond) {
            return cargaOne.getIDENTIFICADOR() - cargaSecond.getIDENTIFICADOR();
        }
    }

    private Screen tela;
    private Clientela listaClientes;
    private Navegacao listaPortos;
    private Estoque estoque;

    public Utils(Screen tela) {
        this.tela = tela;
        listaClientes = new Clientela();
        listaPortos = new Navegacao();
        estoque = new Estoque();
        createCliente();
        createPorto();
    }

    public void createCliente() {
        listaClientes.adicionarCliente(new Cliente(0,"James","goslingJames@gmail.com"));
        listaClientes.adicionarCliente(new Cliente(1,"Anders","hejlsbergAnders@hotmail.com"));
        listaClientes.adicionarCliente(new Cliente(2,"Joana","joana@outlook.com"));
        listaClientes.adicionarCliente(new Cliente(3,"Lucas","lucas@outlook.com"));
        listaClientes.adicionarCliente(new Cliente(4,"Ada","lovelaceAda@gmail.com"));
    }

    public void createPorto() {
        listaPortos.adicionarPorto(new Porto(0,"Calgary","Canadá"));
        listaPortos.adicionarPorto(new Porto(1,"Madrid","Espanha"));
        listaPortos.adicionarPorto(new Porto(2,"Porto Alegre","Brasil"));
        listaPortos.adicionarPorto(new Porto(3,"Moscow","Rússia"));
        listaPortos.adicionarPorto(new Porto(4,"Tóquio","Japão"));
    }

    public void createCarga() throws NumberFormatException {
        boolean create = false;
        String information = "";

        String cliente = tela.getTextCliente().getText();
        String portoOrigem = tela.getTextPortoOrigem().getText();
        String portoDestino = tela.getTextPortoDestino().getText();
        String id = tela.getTextID().getText();
        String tipoId = tela.getTextTipoID().getText();
        String tempoMax = tela.getTextTempoMax().getText();
        String validadeMax = tela.getTextValidadeMax().getText();
        String imposto = tela.getTextImposto().getText();
        String desc = tela.getTextDesc().getText();
        String origem = tela.getTextOrigem().getText();
        String material = tela.getTextMaterial().getText();
        String setor = tela.getTextSetor().getText();
        String peso = tela.getTextPeso().getText();
        String valorDeclarado = tela.getTextValorDeclarado().getText();

        // Se todos forem 'false'
        if ((!cliente.isEmpty()) && (!portoOrigem.isEmpty()) && (!portoDestino.isEmpty())) {
            Cliente c = listaClientes.consulta(Integer.parseInt(cliente)); // Realiza conversões
            Porto o = listaPortos.consulta(Integer.parseInt(portoOrigem));
            Porto d = listaPortos.consulta(Integer.parseInt(portoDestino));

            if (c != null && o != null && d != null) { // Se existerem, faz as demais verificações
                if ((!id.isEmpty()) && (!desc.isEmpty()) && (!peso.isEmpty()) && (!valorDeclarado.isEmpty()) && (!tempoMax.isEmpty())) {

                    int identificador = Integer.parseInt(id); // Realiza conversões
                    int kg = Integer.parseInt(peso);
                    int tempo = Integer.parseInt(tempoMax);
                    double valor = Double.parseDouble(valorDeclarado);
                    if (((!tipoId.isEmpty()) && (!origem.isEmpty()) && (!validadeMax.isEmpty()))
                            && ((imposto.isEmpty()) && (material.isEmpty()) && (setor.isEmpty()))) {

                        int tipo = Integer.parseInt(tipoId); // Realiza conversões
                        int validade = Integer.parseInt(validadeMax);

                        TipoCarga tipoCarga = new Perecivel(tipo, origem, validade, desc);
                        // Faz as instancias
                        if (estoque.adicionarCarga(new Carga(identificador, tipoCarga, c, o, d, kg, valor, tempo))) {
                            create = true;
                        } else {
                            information = "Carga já existente!";
                        }
                        // Reordena a lista
                        Collections.sort(estoque.getEstoque(), new OrderEstoque());

                    } else if (((!tipoId.isEmpty()) && (origem.isEmpty()) && (validadeMax.isEmpty()))
                            && ((!imposto.isEmpty()) && (!material.isEmpty()) && (!setor.isEmpty()))) {

                        int tipo = Integer.parseInt(tipoId); // Realiza conversões
                        double percentual = Double.parseDouble(imposto);
                        // Faz as instancias
                        TipoCarga tipoCarga = new Duravel(tipo, setor, material, percentual, desc);

                        if (estoque.adicionarCarga(new Carga(identificador, tipoCarga, c, o, d, kg, valor, tempo))) {
                            create = true;
                        } else {
                            information = "Carga já existente!";
                        }
                        // Reordena a lista
                        Collections.sort(estoque.getEstoque(), new OrderEstoque());
                    } else {
                        information = "Tipo de carga inválida!";
                    }
                } else {
                    information = "Campos com dados da carga incompletos!";
                }
            } else {
                information = "Cliente e/ou Portos não existem!";
            }
        } else {
            information = "Campos não incompletos!";
        }

        if (create) { // Se foi realizado o cadastro
            tela.setHeaderInformation("CADASTRADO COM SUCESSO");
            tela.setInformation("Nova carga adicionada");

            System.out.println(estoque.toString());
        } else { // Senão foi
            tela.setHeaderInformation("FALHA NO CADASTRO");
            tela.setInformation(information);

            System.out.println(estoque.toString());
        }
    }

    public void clearFields(Container box) {
        for (Component component : box.getComponents()) {
            if (component instanceof JFormattedTextField) {
                JFormattedTextField field = (JFormattedTextField) component;
                field.setValue(null);
            } else if (component instanceof JTextField) {
                JTextField field = (JTextField) component;
                field.setText("");
            } else if (component instanceof JTextArea) {
                JTextArea area = (JTextArea) component;
                area.setText("");
            } else if (component instanceof Container) {
                clearFields((Container) component);
            }
        }
        tela.getHeaderInformation().setText("");
        tela.getInformation().setText("");
    }
}
