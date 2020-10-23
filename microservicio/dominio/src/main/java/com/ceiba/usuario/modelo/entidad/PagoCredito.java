package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Setter
@Getter
public class PagoCredito {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_PAGO = "Se debe ingresar la fecha de pago";
    private static final String SE_DEBE_INGRESAR_ID_CREDITO = "Se debe ingresar el id del credito";


    private Long id;
    private Integer idCredito;
    private Double valorCuota;
    private Double valorMora;
    private Date fechaPago;
    private Integer tipoPago;

    public PagoCredito(Long id, Integer idCredito, Double valorCuota, Double valorMora, Date fechaPago, Integer tipoPago) {

        validarObligatorio(idCredito, SE_DEBE_INGRESAR_ID_CREDITO);

        validarObligatorio(fechaPago, SE_DEBE_INGRESAR_LA_FECHA_PAGO);

        this.id = id;
        this.idCredito = idCredito;
        this.valorCuota = valorCuota;
        this.valorMora = valorMora;
        this.fechaPago = fechaPago;
        this.tipoPago = tipoPago;

    }
}
