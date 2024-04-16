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

    @DeleteMapping()
    public String eliminarSucursal(@ModelAttribute("sucursal") int idSucursal, Model model){
        sucursalesService.borrarSucursal(idSucursal);
        return "redirect:/sucursal";
    }

    @GetMapping("/{idSucursal}")
    public String detallesSucursal(@PathVariable("idSucursal") int id, Model model){
        Sucursal sucursal = sucursalesService.listarSucursales().get(id);
        model.addAttribute("sucursal",sucursal);

        return "sucursalDetalles";
    }

    @PutMapping(value = "/{idSucursal}")
    public boolean modificarSucursal(@PathVariable int idSucursal, @RequestBody Sucursal sucursal){
        return sucursalesService.modificarSucursal(idSucursal,sucursal);
    }




}
