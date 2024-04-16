package com.babel.mvc.service;

import com.babel.mvc.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService implements IClienteService {
    private final Map<Integer, Cliente> clientes = new HashMap<>();
    private int proximoId = 1;

    @Override
    public Map<Integer, Cliente> listarClientes() {
        return clientes;
    }

    @Override
    public Cliente obtenerClientePorId(int id) {
        return clientes.get(id);
    }

    @Override
    public Cliente obtenerClientePorDni(String dni) {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public Cliente obtenerClientePorEmail(String email) {
        for (Cliente cliente : clientes.values()) {
            if (cliente.getEmail().equals(email)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public boolean altaCliente(Cliente cliente) {
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
    public boolean borrarCliente(int id) {
        if (clientes.containsKey(id)) {
            clientes.remove(id);
            return true;
        }
        return false;
    }
}
