package com.babel.mvc.model;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Cliente {
    private int id;
    private String dni;
    private String nombre;
    private String direccionPostal;
    private String email;
    private String telefono;
    private int sucursalPrincipalId;
}


