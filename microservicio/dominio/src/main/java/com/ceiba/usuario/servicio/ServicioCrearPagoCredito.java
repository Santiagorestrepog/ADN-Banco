package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.modelo.entidad.PagoCredito;
import com.ceiba.usuario.puerto.repositorio.RepositorioPagoCredito;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearPagoCredito {

    private final RepositorioPagoCredito repositorioPagoCredito;
    private static final String EL_USUARIO_TIENE_CREDITO_EN_EL_SISTEMA = "El usuario tiene un credito vigente";


    public ServicioCrearPagoCredito(RepositorioPagoCredito repositorioPagoCredito) {
        this.repositorioPagoCredito = repositorioPagoCredito;
    }

    public Long ejecutar(PagoCredito pagoCredito) {

        validarExistenciaPreviaCredito(pagoCredito);

        return this.repositorioPagoCredito.crear(pagoCredito);
    }

    private void validarExistenciaPreviaCredito(PagoCredito pagoCredito) {

        pagoCredito.setValorCuota(10000.0);

    }

}
