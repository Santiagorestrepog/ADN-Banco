package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.puerto.repositorio.RepositorioCredito;

public class ServicioCrearCredito {

    private static final String EL_USUARIO_TIENE_CREDITO_EN_EL_SISTEMA = "El usuario tiene un credito vigente";

    private final RepositorioCredito repositorioCredito;

    public ServicioCrearCredito(RepositorioCredito repositorioCredito) {
        this.repositorioCredito = repositorioCredito;
    }

    public Long ejecutar(Credito credito) {
        validarExistenciaPreviaCredito(credito);
        return this.repositorioCredito.crear(credito);
    }

    private void validarExistenciaPreviaCredito(Credito credito) {
        boolean existe = this.repositorioCredito.existe(credito.getIdUsuario(),credito.getEstado());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_TIENE_CREDITO_EN_EL_SISTEMA);
        }
    }

}

