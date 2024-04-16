package com.babel.mvc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Sucursal {
    private int id;
    private String nombre;
    private String Director;
    private String Direccion;
}
