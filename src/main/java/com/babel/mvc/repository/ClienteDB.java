package com.babel.mvc.repository;

import com.babel.mvc.model.Cliente;

import java.util.HashMap;
import java.util.Map;

public class ClienteDB implements IClienteDB {
    private final Map<Integer, Cliente> clientes = new HashMap<>();
    private int proximoId = 1;

    @Override
    public Map<Integer, Cliente> listarClientes() {
        return clientes;
    }

    @Override
    public Cliente getClienteById(int id) {
        return clientes.get(id);
    }

    @Override
    public Cliente getClienteByDni(String dni) {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente getClienteByEmail(String email) {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getEmail().equals(email)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public boolean addCliente(Cliente cliente) {
        cliente.setId(proximoId++);
        clientes.put(cliente.getId(), cliente);
        return true;
    }

    @Override
    public boolean modificarCliente(int id, Cliente cliente) {
        if (clientes.containsKey(id)) {
            cliente.setId(id);
            clientes.put(id, cliente);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarCliente(int id) {
        if (clientes.containsKey(id)) {
            clientes.remove(id);
            return true;
        }
        return false;
    }
}
