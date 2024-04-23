package com.babel.mvc.service;

import com.babel.mvc.model.Sucursal;
import com.babel.mvc.repository.ISucursalDB;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SucursalesService implements ISucursalesService{

    private final ISucursalDB sucursalDB;

    public SucursalesService(ISucursalDB sucursalDB) {
        this.sucursalDB = sucursalDB;
    }

    @Override
    public Map<Integer, Sucursal> listarSucursales() {
        return sucursalDB.listarSucursales();
    }

    @Override
    public boolean altaSucursal(Sucursal sucursal) {
        return sucursalDB.altaSucursal(sucursal);
    }

    @Override
    public boolean modificarSucursal(int idSucursal, Sucursal sucursal) {
        if (idSucursal == sucursal.getId()){
            return sucursalDB.modificarSucursal(idSucursal,sucursal);
        }
        return false;
    }

    @Override
    public boolean borrarSucursal(int idSucursal) {
        if (idSucursal <= sucursalDB.listarSucursales().size() ){
            return sucursalDB.borrarSucursal(idSucursal);
        }
        return false;
    }
}
