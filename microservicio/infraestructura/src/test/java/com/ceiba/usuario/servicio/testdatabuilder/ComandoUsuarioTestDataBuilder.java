package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String tipoDocumento;
    private String correo;
    private Date fechaCreacion;


    public ComandoUsuarioTestDataBuilder() {
        nombre = "Santiago";
        apellidos = "Restrepo";
        cedula = "1152691643";
        tipoDocumento = "CC";
        correo = "correo@correo.com";
        fechaCreacion = new Date();
    }


    public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre,apellidos,cedula,tipoDocumento,correo,fechaCreacion);
    }
}
