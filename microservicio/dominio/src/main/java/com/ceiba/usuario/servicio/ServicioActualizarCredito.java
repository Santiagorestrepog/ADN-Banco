package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.puerto.repositorio.RepositorioCredito;

public class ServicioActualizarCredito {

    private final RepositorioCredito repositorioCredito;

    public ServicioActualizarCredito(RepositorioCredito repositorioCredito) {

        this.repositorioCredito = repositorioCredito;
    }

    public void ejecutar(Credito credito) {

        this.repositorioCredito.actualizar(credito);

    }

}
