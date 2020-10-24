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
public class ComandoCredito {

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
