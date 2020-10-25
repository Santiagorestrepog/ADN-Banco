package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoPagoCredito;

import java.util.Date;

public class ComandoPagoCreditoTestDataBuilder {

    private Long id;
    private Integer idCredito;
    private Double valorCuota;
    private Double valorMora;
    private Date fechaPago;
    private Integer tipoPago;

    public ComandoPagoCreditoTestDataBuilder() {

        id = 1l;
        idCredito=2;
        valorCuota = 100000d;
        valorMora = 0d;
        fechaPago = new Date();
        tipoPago = 2;

    }

    public ComandoPagoCredito build() {
        return new ComandoPagoCredito(id, idCredito, valorCuota, valorMora, fechaPago, tipoPago);
    }
}
