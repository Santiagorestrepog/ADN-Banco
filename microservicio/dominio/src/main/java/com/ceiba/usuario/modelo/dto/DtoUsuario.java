package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoUsuario {
    private Long id;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String tipoDocumento;
    private String correo;
    private Date fechaCreacion;

}
