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
        calcularInteres(credito);
        calcularCuota(credito);
        return this.repositorioCredito.crear(credito);
    }

    private void validarExistenciaPreviaCredito(Credito credito) {

        boolean existe = this.repositorioCredito.existe(credito.getIdUsuario(),true);

        if(existe) {

            throw new ExcepcionDuplicidad(EL_USUARIO_TIENE_CREDITO_EN_EL_SISTEMA);

        }
    }

    private void calcularInteres(Credito credito){

        double tasainteres = this.repositorioCredito.tasaInteres(credito.getIdTasa());

        Double valorInteres = credito.getValorCredito() * tasainteres / 100;
        Double valorCreditoInteres = credito.getValorCredito() + valorInteres;

        credito.setValorCreditoInteres(valorCreditoInteres);
        credito.setValorTotalPagar(valorCreditoInteres);

    }

    private void calcularCuota(Credito credito){

        Integer cuotaTotal = credito.getCuotasTotales();
        Double valorCredito = credito.getValorCreditoInteres();
        Double valorCuota = valorCredito / cuotaTotal;

        credito.setValorCuotas(valorCuota);

    }


}

