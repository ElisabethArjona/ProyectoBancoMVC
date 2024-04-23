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

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable int id){
        return clienteService.obtenerClientePorId(id);
    }

    @GetMapping("/dni/{dni}")
    public Cliente getClienteByDni(@PathVariable String dni){
        return clienteService.obtenerClientePorDni(dni);
    }

    @GetMapping("/email/{email}")
    public Cliente getClienteByEmail(@PathVariable String email){
        return clienteService.obtenerClientePorEmail(email);
    }

    @PostMapping
    public String addCliente(@ModelAttribute("cliente") Cliente cliente, Model model){
        clienteService.altaCliente(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/detalles/{id}")
    public String clienteDetalles(@PathVariable int id, Model model){
        Cliente cliente = clienteService.listarClientes().get(id);
        model.addAttribute("cliente",cliente);
        return "clienteDetalles";
    }

    @PutMapping(value = "/{id}")
    public boolean modificarCliente(@PathVariable int id, @RequestBody Cliente cliente){
        return clienteService.modificarCliente(id, cliente);
    }

    @PostMapping(value = "/delete/{id}")
    public String eliminarCliente(@PathVariable("id") int id, Model model){
        clienteService.borrarCliente(id);
        return "redirect:/cliente";
    }
}
