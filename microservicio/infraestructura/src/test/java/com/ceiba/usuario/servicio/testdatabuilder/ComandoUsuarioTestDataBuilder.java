package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.util.Date;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String tipoDocumento;
    private String correo;
    private Date fechaCreacion;



    public ComandoUsuarioTestDataBuilder() {
        id = 12l;
        nombre = "Juan";
        apellidos = "Restrepo";
        cedula = "1122564995";
        tipoDocumento = "CC";
        correo = "correo@correo.com";
        fechaCreacion = new Date();
    }


    public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre,apellidos,cedula,tipoDocumento,correo,fechaCreacion);
    }
}
