package controller;

import controller.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Events implements ActionListener {
    private Container box;
    private Utils utils;
    private ArrayList<JButton> buttons;

    public Events() {
        buttons = new ArrayList<>();
    }

    public void setButtons(JButton button) { // Armazena os JButtons atribuídos para tratamento
        if(!buttons.contains(button)) {
            buttons.add(button);
        }
    }

    public void setBox(Container box) {
        this.box = box;
    }

    public void setUtils(Utils utils) {
        this.utils = utils;
    }

    public void actionButtons() { // Define o tratamento de evento para cada JButton
        for (JButton button : buttons) {
            ActionEvent action = (ActionEvent) button.getAction();
            if (action != null) actionPerformed(action);
        }
    }

    @Override
    public void actionPerformed(ActionEvent button) {
        if (button.getActionCommand().equals("finalizar")) {
            Runtime.getRuntime().exit(0);
        }
        else if (button.getActionCommand().equals("limpar")) {
            utils.clearFields(box);
        }
        else if (button.getActionCommand().equals("confirmar")) {
            try {
                utils.createCarga();
            } catch (NumberFormatException e) {
                System.err.format("Campo(s) inválido(s): %s%n", e);
            } catch (IllegalArgumentException e) {
                System.err.format("E/S inválida: %s%n", e);
            } catch (NullPointerException e) {
                System.err.format("Instância nula: %s%n", e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
