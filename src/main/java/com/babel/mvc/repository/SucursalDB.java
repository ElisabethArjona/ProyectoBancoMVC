package com.babel.mvc.repository;

import com.babel.mvc.model.Sucursal;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SucursalDB implements ISucursalDB {

    private Map<Integer, Sucursal> listaSucursales = new HashMap<>();

    @Override
    public Map<Integer, Sucursal> listarSucursales() {
        return listaSucursales;
    }

    @Override
    public boolean altaSucursal(Sucursal sucursal) {
        listaSucursales.put(sucursal.getId(),sucursal);
        return true;
    }

    @Override
    public boolean modificarSucursal(int idSucursal, Sucursal sucursal) {
        listaSucursales.replace(idSucursal,sucursal);
        return true;
    }

    @Override
    public boolean borrarSucursal(int idSucursal) {
        if(listaSucursales.remove(idSucursal) != null){
            return true;
        }
        return false;
    }
}
