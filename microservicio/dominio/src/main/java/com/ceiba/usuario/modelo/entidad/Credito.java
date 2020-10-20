package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Setter
@Getter
public class Credito {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREDITO = "Se debe ingresar la fecha de inicio de credito";
    private static final String SE_DEBE_INGRESAR_TIPO_CREDITO = "Se debe ingresar el tipo de credito";
    private static final String SE_DEBE_INGRESAR_TAZA_INTERES = "Se debe ingresar la taza de interes";
    private static final String SE_DEBE_INGRESAR_VALOR_CREDITO = "Se debe ingresar el valor del credito solicitado";
    private static final String SE_DEBE_INGRESAR_CUOTAS_TOTALES = "Se debe ingresar las cuotas totales";
    private static final String SE_DEBE_INGRESAR_ESTADO = "Se debe ingresar estado de credito";

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


    public Credito(Long id, Double valorCredito, Integer idUsuario, String tipoCredito, Integer tasaInteres, Integer cuotasTotales, Integer cuotasPagadas, Boolean estado, Double valorActual, Double interesMora, Date fechacredito) {
        validarObligatorio(valorCredito, SE_DEBE_INGRESAR_VALOR_CREDITO);
        validarObligatorio(tipoCredito, SE_DEBE_INGRESAR_TIPO_CREDITO);
        validarObligatorio(tasaInteres, SE_DEBE_INGRESAR_TAZA_INTERES);
        validarObligatorio(cuotasTotales, SE_DEBE_INGRESAR_CUOTAS_TOTALES);
        validarObligatorio(estado, SE_DEBE_INGRESAR_ESTADO);
        validarObligatorio(fechacredito, SE_DEBE_INGRESAR_LA_FECHA_CREDITO);

        this.id = id;
        this.valorCredito = valorCredito;
        this.idUsuario = idUsuario;
        this.tipoCredito = tipoCredito;
        this.tasaInteres = tasaInteres;
        this.cuotasTotales = cuotasTotales;
        this.cuotasPagadas = cuotasPagadas;
        this.estado = estado;
        this.valorActual = valorActual;
        this.interesMora = interesMora;
        this.fechacredito = fechacredito;
    }
}
