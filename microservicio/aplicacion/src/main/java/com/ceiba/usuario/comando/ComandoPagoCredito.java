package com.ceiba.usuario.comando;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPagoCredito {

    private Long id;
    private Integer idCredito;
    private Double valorCuota;
    private Double valorMora;
    private Date fechaPago;
    private Integer tipoPago;

}
