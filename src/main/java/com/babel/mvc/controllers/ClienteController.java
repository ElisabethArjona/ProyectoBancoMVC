package com.babel.mvc.controllers;

import com.babel.mvc.model.Cliente;
import com.babel.mvc.model.Sucursal;
import com.babel.mvc.service.IClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {
    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public void cliente(Model model){
        ArrayList<Cliente> clientes = new ArrayList<>(clienteService.listarClientes().values());
        model.addAttribute("clientes",clientes);
    }

    @GetMapping(value = "/{id}")
    public Cliente getClienteById(@PathVariable int id){
        return clienteService.obtenerClientePorId(id);
    }

    @GetMapping(value = "/dni/{dni}")
    public Cliente getClienteByDni(@PathVariable String dni){
        return clienteService.obtenerClientePorDni(dni);
    }

    @GetMapping(value = "/email/{email}")
    public Cliente getClienteByEmail(@PathVariable String email){
        return clienteService.obtenerClientePorEmail(email);
    }

    @PostMapping
    public String addCliente(@ModelAttribute("cliente") Cliente cliente, Model model){
        clienteService.altaCliente(cliente);
        return "redirect:/cliente";
    }

    @PutMapping(value = "/{id}")
    public boolean modificarCliente(@PathVariable int id, @RequestBody Cliente cliente){
        return clienteService.modificarCliente(id, cliente);
    }

    @DeleteMapping(value = "/{id}")
    public boolean eliminarCliente(@PathVariable int id){
        return clienteService.borrarCliente(id);
    }
}
