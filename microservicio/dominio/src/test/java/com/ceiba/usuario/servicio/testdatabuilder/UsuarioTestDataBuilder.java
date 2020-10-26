package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;
import java.util.Date;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String tipoDocumento;
    private String correo;
    private Date fechaCreacion;

    public UsuarioTestDataBuilder() {
        nombre = "Santiago";
        apellidos = "Restrepo";
        cedula = "1152691643";
        tipoDocumento = "CC";
        correo = "correo@correo.com";
        fechaCreacion = new Date();
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,nombre,apellidos,cedula,tipoDocumento,correo,fechaCreacion);
    }
}
