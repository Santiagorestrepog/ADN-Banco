package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Credito;
import java.util.Date;

public class CreditoTestDataBuilder {

    private Long id;
    private Double valorCredito;
    private Integer idUsuario;
    private String tipoCredito;
    private Integer tazaInteres;
    private Integer cuotasTotales;
    private Integer cuotasPagadas;
    private Boolean estado;
    private Double valorActual;
    private Double interesMora;
    private Date fechacredito;

    public CreditoTestDataBuilder() {

        valorCredito = 10000.0;
        idUsuario = 123;
        tipoCredito = "Libre";
        tazaInteres = 1;
        cuotasTotales = 3;
        cuotasPagadas = 2;
        estado = true;
        valorActual = 10000.0;
        interesMora = 0.0;
        fechacredito = new Date();

    }

    public Credito build() { return new Credito(id,valorCredito,idUsuario,tipoCredito,tazaInteres,cuotasTotales,cuotasPagadas,estado,valorActual,interesMora, fechacredito);
    }



}
