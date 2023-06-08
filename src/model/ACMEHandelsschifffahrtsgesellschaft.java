package model;

import controller.Events;
import controller.utils.Utils;
import view.Screen;

public class ACMEHandelsschifffahrtsgesellschaft {

    public ACMEHandelsschifffahrtsgesellschaft() {
        Events events = new Events(); // Crio a instância de tratamento de eventos
        Screen screen = new Screen(events); // Atribuo a classe Events, os botões a serem tratados
        events.setUtils(new Utils(screen)); // Determino o tratamento para cada evento
        events.actionButtons(); // Atribuo a cada botão um tratamento especifico
    }
}
