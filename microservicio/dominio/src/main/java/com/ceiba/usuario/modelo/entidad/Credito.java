package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarNegativo;
import static com.ceiba.dominio.ValidadorArgumento.validarMontoMinimo;
import static com.ceiba.dominio.ValidadorArgumento.validarNegativoInt;


@Setter
@Getter
public class Credito {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREDITO = "Se debe ingresar la fecha de inicio de credito";
    private static final String SE_DEBE_INGRESAR_VALOR_CREDITO = "Se debe ingresar el valor del credito solicitado";
    private static final String SE_DEBE_INGRESAR_CUOTAS_TOTALES = "Se debe ingresar las cuotas totales";
    private static final String SE_DEBE_INGRESAR_UN_IDUSUARIO_VALIDO = "Se debe ingresar un idUsuario valido";
    private static final String SE_DEBE_INGRESAR_TASA_INTERES = "Se debe ingresar la tasa de interes";
    private static final String MONTO_MINIMO = "El monto minimo es de 10.000 pesos";
    private static final String VALOR_NEGATIVO_CREDITO = "El valor no puede ser negativo";
    private static final String VALOR_NEGATIVO_CUOTA = "La cuota no puede ser negativa";


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


    public Credito(Long id, Integer idUsuario, Integer idTasa, Double valorCredito, Double valorCreditoInteres, Double valorTotalPagar, Double valorTotalPagado,Double valorCuotas, Integer cuotasTotales, Integer cuotasPagadas, Double interesMora, Boolean estado, Date fechaCredito) {

        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_UN_IDUSUARIO_VALIDO);

        validarObligatorio(idTasa, SE_DEBE_INGRESAR_TASA_INTERES);

        validarObligatorio(valorCredito, SE_DEBE_INGRESAR_VALOR_CREDITO);
        validarNegativo(valorCredito, VALOR_NEGATIVO_CREDITO);
        validarMontoMinimo(valorCredito, MONTO_MINIMO);

        validarObligatorio(cuotasTotales, SE_DEBE_INGRESAR_CUOTAS_TOTALES);
        validarNegativoInt(cuotasTotales, VALOR_NEGATIVO_CUOTA);

        validarObligatorio(fechaCredito, SE_DEBE_INGRESAR_LA_FECHA_CREDITO);

        this.id = id;
        this.idUsuario = idUsuario;
        this.idTasa = idTasa;
        this.valorCredito = valorCredito;
        this.valorCreditoInteres = valorCreditoInteres;
        this.valorTotalPagar = valorTotalPagar;
        this.valorTotalPagado = valorTotalPagado;
        this.valorCuotas = valorCuotas;
        this.cuotasTotales = cuotasTotales;
        this.cuotasPagadas = cuotasPagadas;
        this.interesMora = interesMora;
        this.estado = estado;
        this.fechaCredito = fechaCredito;
    }

}
