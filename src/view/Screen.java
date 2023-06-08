package view;

import controller.Events;

import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {
    private JPanel box;
    private JButton buttonFinish;
    private JButton buttonClear;
    private JButton buttonConfirm;
    private Events events;
    private JTextField textCliente;
    private JTextField textPortoOrigem;
    private JTextField textPortoDestino;
    private JTextField textID;
    private JTextField textPeso;
    private JTextField textValorDeclarado;
    private JTextField textTempoMax;
    private JTextField textTipoID;
    private JTextField textDesc;
    private JTextField textSetor;
    private JTextField textMaterial;
    private JTextField textOrigem;
    private JTextField textImposto;
    private JTextField textValidadeMax;
    private JLabel headerInformation;
    private JLabel information;

    public Screen(Events events) {
        super("Sistema de Cadastro de Carga");
        this.setSize(600,500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.events = events;
        createUIComponents();
        this.events.setBox(box); // Informo a Events o JPanel principal
        this.setVisible(true);
    }

    public void createUIComponents() {
        // Config de layouts
        box = new JPanel();
        box.setLayout(new GridLayout(12,1,5,5));
        box.setBorder(BorderFactory.createEmptyBorder(30,40,0,40));
        this.add(box);
        // Cria campos de texto
        createTextFields();
        // Cria os botões
        createButtons();
        // Cria área de informação
        createInformationFields();
    }

    public void createButtons() {
        JPanel painelButtons = new JPanel(new FlowLayout()); // Configura o layout

        buttonFinish = new JButton("Finalizar");
        buttonFinish.setForeground(Color.WHITE);
        buttonFinish.setBackground(new Color(126, 32, 32));
        buttonFinish.setActionCommand("finalizar");
        buttonFinish.addActionListener(events);
        events.setButtons(buttonFinish);
        painelButtons.add(buttonFinish);

        buttonClear = new JButton("Limpar");
        buttonClear.setActionCommand("limpar");
        buttonClear.addActionListener(events);
        events.setButtons(buttonClear);
        painelButtons.add(buttonClear);

        buttonConfirm = new JButton("Confirmar");
        buttonConfirm.setForeground(Color.WHITE);
        buttonConfirm.setBackground(new Color(70, 136, 36));
        buttonConfirm.setActionCommand("confirmar");
        buttonConfirm.addActionListener(events);
        events.setButtons(buttonConfirm);
        painelButtons.add(buttonConfirm);

        box.add(painelButtons);
    }

    public void createTextFields() {
        // Criação do header da tela
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel header = new JLabel("CADASTRO DE CARGA");
        header.setFont(new Font("Arial", Font.BOLD, 16));
        painel.add(header);
        box.add(painel);

        // Áreas de texto linha 1
        JPanel painelText1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        painelText1.add(new JLabel("ID da carga: "));
        textID = new JTextField(13);
        painelText1.add(textID);
        painelText1.add(new JLabel("ID cliente: "));
        textCliente = new JTextField(19);
        painelText1.add(textCliente);
        box.add(painelText1);

        // Áreas de texto linha 2
        JPanel painelText2 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        painelText2.add(new JLabel("ID tipo de carga: "));
        textTipoID = new JTextField(10);
        painelText2.add(textTipoID);
        painelText2.add(new JLabel("Tempo máximo (dias): "));
        textTempoMax = new JTextField(13);
        painelText2.add(textTempoMax);
        box.add(painelText2);

        // Áreas de texto linha 3
        JPanel painelText3 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        painelText3.add(new JLabel("Setor da carga: "));
        textSetor = new JTextField(12);
        painelText3.add(textSetor);
        painelText3.add(new JLabel("Material principal: "));
        textMaterial = new JTextField(14);
        painelText3.add(textMaterial);
        box.add(painelText3);

        // Áreas de texto linha 4
        JPanel painelText4 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        painelText4.add(new JLabel("Origem: "));
        textOrigem = new JTextField(15);
        painelText4.add(textOrigem);
        painelText4.add(new JLabel("Válidade máxima (dias): "));
        textValidadeMax = new JTextField(12);
        painelText4.add(textValidadeMax);
        box.add(painelText4);

        // Áreas de texto linha 5
        JPanel painelText5 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        painelText5.add(new JLabel("Imposto IPI: "));
        textImposto = new JTextField(7);
        painelText5.add(textImposto);
        painelText5.add(new JLabel("Valor declarado: "));
        textValorDeclarado = new JTextField(7);
        painelText5.add(textValorDeclarado);
        painelText5.add(new JLabel("Peso (Kg): "));
        textPeso = new JTextField(7);
        painelText5.add(textPeso);
        box.add(painelText5);

        // Áreas de texto linha 6
        JPanel painelText6 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        painelText6.add(new JLabel("ID Porto de origem: "));
        textPortoOrigem = new JTextField(11);
        painelText6.add(textPortoOrigem);
        painelText6.add(new JLabel("ID Porto de destino: "));
        textPortoDestino = new JTextField(11);
        painelText6.add(textPortoDestino);
        box.add(painelText6);

        // Áreas de texto linha 7
        JPanel painelText7 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        painelText7.add(new JLabel("Descrição: "));
        textDesc = new JTextField(40);
        painelText7.add(textDesc);
        box.add(painelText7);
    }

    public void createInformationFields() {
        // Área que mostra as informações linha 8
        JPanel painelText7 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        JLabel textInformation = new JLabel("Informações:");
        textInformation.setFont(new Font("Arial", Font.BOLD,13));
        painelText7.add(textInformation);
        headerInformation = new JLabel();
        painelText7.add(headerInformation);
        box.add(painelText7);
        // Área que mostra as informações linha 9
        JPanel painelText8 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        information = new JLabel();
        painelText8.add(information);
        box.add(painelText8);
    }
    // Método acessores
    public JLabel getHeaderInformation() {
        return headerInformation;
    }

    public void setHeaderInformation(String text) {
        if (text.equals("CADASTRADO COM SUCESSO")) {
            headerInformation.setForeground(Color.GREEN);
        } else {
            headerInformation.setForeground(Color.RED);
        }
        headerInformation.setText(text);
    }

    public void setInformation(String text) {
        information.setText(text);
    }

    public JLabel getInformation() {
        return information;
    }

    public JTextField getTextID() {
        return textID;
    }

    public JTextField getTextCliente() {
        return textCliente;
    }

    public JTextField getTextPortoOrigem() {
        return textPortoOrigem;
    }

    public JTextField getTextPortoDestino() {
        return textPortoDestino;
    }

    public JTextField getTextPeso() {
        return textPeso;
    }

    public JTextField getTextValorDeclarado() {
        return textValorDeclarado;
    }

    public JTextField getTextTempoMax() {
        return textTempoMax;
    }

    public JTextField getTextTipoID() {
        return textTipoID;
    }

    public JTextField getTextDesc() {
        return textDesc;
    }

    public JTextField getTextSetor() {
        return textSetor;
    }

    public JTextField getTextMaterial() {
        return textMaterial;
    }

    public JTextField getTextOrigem() {
        return textOrigem;
    }

    public JTextField getTextImposto() {
        return textImposto;
    }

    public JTextField getTextValidadeMax() {
        return textValidadeMax;
    }
}
