package com.ceiba.usuario.comando;

import java.time.LocalDateTime;
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


}
