package com.babel.mvc.repository;

import com.babel.mvc.model.Cliente;

import java.util.Map;

public interface IClienteDB {
    Map<Integer, Cliente> listarClientes();

    Cliente getClienteById(int id);

    Cliente getClienteByDni(String dni);

    Cliente getClienteByEmail(String email);

    boolean addCliente(Cliente cliente);

    boolean modificarCliente(int id, Cliente cliente);

    boolean eliminarCliente(int id);
}
