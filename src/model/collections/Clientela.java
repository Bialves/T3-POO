package model.collections;

import model.Cliente;
import java.util.ArrayList;

public class Clientela {
    private ArrayList<Cliente> clientela;

    public Clientela() {
        clientela = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientela() {
        return clientela;
    }

    public boolean adicionarCliente(Cliente cliente) {
        if (consulta(cliente.getIDENTIFICADOR()) == null) {
            return clientela.add(cliente);
        }
        return false;
    }

    public Cliente consulta(int id) {
        for (Cliente cliente : clientela) {
            if (cliente.getIDENTIFICADOR() == id) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sc = new StringBuilder();
        for (Cliente cliente :  clientela) {
            sc.append(cliente.toString());
            sc.append("\n");
        }
        return sc.toString();
    }
}
