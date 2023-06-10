package model;

import controller.Events;
import controller.utils.Utils;
import view.Screen;

public class ACMEHandelsschifffahrtsgesellschaft {

    public ACMEHandelsschifffahrtsgesellschaft() {
        Events events = new Events(); // Crio a classe tratadora de eventos
        Screen screen = new Screen(events); // Atribuo a classe tratadora, os botões a serem tratados
        events.setUtils(new Utils(screen)); // Determino o tratamento para os possíveis eventos
        events.actionButtons(); // Atribuo os tratamentos determinados para botões específicos
    }
}
