package com.babel.mvc.service;

import com.babel.mvc.model.Sucursal;

import java.util.Map;

public interface ISucursalesService {

    public Map<Integer, Sucursal> listarSucursales();

    public boolean altaSucursal(Sucursal sucursal);

    public boolean modificarSucursal(int idSucursal, Sucursal sucursal);

    public boolean borrarSucursal(int idSucursal);
}
