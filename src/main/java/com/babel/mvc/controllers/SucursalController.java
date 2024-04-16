package com.babel.mvc.controllers;

import com.babel.mvc.model.Sucursal;
import com.babel.mvc.service.ISucursalesService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/sucursales")
public class SucursalController {

    private final ISucursalesService sucursalesService;

    public SucursalController(ISucursalesService sucursalesService) {
        this.sucursalesService = sucursalesService;
    }

    @GetMapping(value = "/listar")
    public ArrayList<Sucursal> listarSucursales(){
        return new ArrayList<>(sucursalesService.listarSucursales().values());
    }

    @PostMapping
    public boolean addSucursal(@RequestBody Sucursal sucursal){
        return  sucursalesService.altaSucursal(sucursal);
    }

    @PutMapping(value = "/{idSucursal}")
    public boolean modificarSucursal(@PathVariable int idSucursal, @RequestBody Sucursal sucursal){
        return sucursalesService.modificarSucursal(idSucursal,sucursal);
    }

    @DeleteMapping(value = "/{idSucursal}")
    public boolean eliminarSucursal(@PathVariable int idSucursal){
        return sucursalesService.borrarSucursal(idSucursal);
    }


}
