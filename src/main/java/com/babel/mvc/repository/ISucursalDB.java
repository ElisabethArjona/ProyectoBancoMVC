package com.babel.mvc.repository;

import com.babel.mvc.model.Sucursal;

import java.util.Map;

public interface ISucursalDB {

    public Map<Integer,Sucursal> listarSucursales();

    public boolean altaSucursal(Sucursal sucursal);

    public boolean modificarSucursal(int idSucursal, Sucursal sucursal);

    public boolean borrarSucursal(int idSucursal);

}
