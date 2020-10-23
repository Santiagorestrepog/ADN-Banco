package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;


@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_APELLIDO_DEL_USUARIO = "Se debe ingresar el apellido del usuario";
    private static final String SE_DEBE_INGRESAR_TIPO_DOCUMENTO_DEL_USUARIO = "Se debe ingresar tipo documento de el usuario";
    private static final String SE_DEBE_INGRESAR_CORREO_DEL_USUARIO = "Se debe ingresar correo del usuario";


    private Long id;
    private String nombre;
    private String apellidos;
    private String cedula;
    private String tipoDocumento;
    private String correo;
    private Date fechaCreacion;

    public Usuario(Long id,String nombre, String apellidos, String cedula, String tipoDocumento, String correo,Date fechaCreacion) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(apellidos, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);

        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.tipoDocumento = tipoDocumento;
        this.correo = correo;

    }

}
