package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Date;

@Getter
@AllArgsConstructor
public class DtoCredito {
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
}
