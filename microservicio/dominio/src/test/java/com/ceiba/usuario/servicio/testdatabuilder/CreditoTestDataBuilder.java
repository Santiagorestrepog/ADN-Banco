package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Credito;
import java.util.Date;

public class CreditoTestDataBuilder {

    private Long id;
    private Integer idUsuario;
    private Integer idTasa;
    private Double valorCredito;
    private Double valorCreditoInteres;
    private Double valorTotalPagar;
    private Double valorTotalPagado;
    private Double valorCuotas;
    private Integer cuotasTotales;
    private Integer cuotasPagadas;
    private Double interesMora;
    private Boolean estado;
    private Date fechaCredito;

    public CreditoTestDataBuilder() {



        idUsuario = 123;
        idTasa = 1;
        valorCredito = 100000d;
        valorCreditoInteres = 105000d;
        valorTotalPagar = 105000d;
        valorTotalPagado = 0d;
        valorCuotas = 35000d;
        cuotasTotales = 3;
        cuotasPagadas = 0;
        interesMora = 0.0;
        estado = true;
        fechaCredito = new Date();


    }

    public Credito build() { return new Credito(id, idUsuario, idTasa, valorCredito, valorCreditoInteres, valorTotalPagar, valorTotalPagado, valorCuotas, cuotasTotales, cuotasPagadas, interesMora, estado, fechaCredito);
    }



}
