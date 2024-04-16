package com.babel.mvc.service;

import com.babel.mvc.model.Cliente;

import java.util.Map;

public interface IClienteService {
    Map<Integer, Cliente> listarClientes();

    Cliente obtenerClientePorId(int id);

    Cliente obtenerClientePorDni(String dni);

    Cliente obtenerClientePorEmail(String email);

    boolean altaCliente(Cliente cliente);

    boolean modificarCliente(int id, Cliente cliente);

    boolean borrarCliente(int id);
}
