package com.babel.mvc.controllers;

import com.babel.mvc.model.Sucursal;
import com.babel.mvc.service.ISucursalesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/sucursal")
public class SucursalController {

    private final ISucursalesService sucursalesService;

    public SucursalController(ISucursalesService sucursalesService) {
        this.sucursalesService = sucursalesService;
    }

    @GetMapping
    public void sucursal(Model model){
        ArrayList<Sucursal> sucursales = new ArrayList<>(sucursalesService.listarSucursales().values());
        model.addAttribute("sucursales",sucursales);
    }

    @PostMapping
    public String addSucursal(@ModelAttribute("sucursal") Sucursal sucursal, Model model){
        sucursalesService.altaSucursal(sucursal);
        return "redirect:/sucursal";
    }

    @PostMapping("/{id}/delete")
    public String eliminarSucursal(@PathVariable("id") Integer id , Model model) {
        sucursalesService.borrarSucursal(id);
        return "redirect:/sucursal";
    }

    @GetMapping("/{idSucursal}")
    public String detallesSucursal(@PathVariable("idSucursal") int id, Model model){
        Sucursal sucursal = sucursalesService.listarSucursales().get(id);
        model.addAttribute("sucursal",sucursal);
        return "sucursalDetalles";
    }

    @PostMapping(value = "/{idSucursal}")
    public String modificarSucursal(@PathVariable("idSucursal") int idSucursal, @ModelAttribute("sucursal") Sucursal sucursal, Model model){
        sucursal.setId(idSucursal);
        sucursalesService.modificarSucursal(idSucursal,sucursal);
        return "redirect:/sucursal/{idSucursal}";
    }




}
