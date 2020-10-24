package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioEliminarUsuario {

    private final RepositorioUsuario repositorioUsuario;
    private static final String EL_USUARIO_TIENE_CREDITO_ACTIVO = "El usuario tiene un credito activo";

    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {

        this.repositorioUsuario = repositorioUsuario;

    }

    public void ejecutar(Long id) {

        validarUsuarioCredito(id);

        this.repositorioUsuario.eliminar(id);
    }

    private void validarUsuarioCredito(Long idUsuario) {

        boolean existe = this.repositorioUsuario.existeUsuarioCredito(idUsuario);

        if(existe) {

            throw new ExcepcionDuplicidad(EL_USUARIO_TIENE_CREDITO_ACTIVO);

        }
    }

}
