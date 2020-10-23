package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

//map consulta

@Getter
@AllArgsConstructor
public class DtoCredito {
    private Long id;
    private Double valorCredito;
    private Integer idUsuario;
    private String tipoCredito;
    private Integer tasaInteres;
    private Integer cuotasTotales;
    private Integer cuotasPagadas;
    private Boolean estado;
    private Double valorActual;
    private Double interesMora;
    private Date fechacredito;
}
