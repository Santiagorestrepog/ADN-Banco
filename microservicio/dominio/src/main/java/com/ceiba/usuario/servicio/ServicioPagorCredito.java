package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.modelo.entidad.PagoCredito;
import com.ceiba.usuario.puerto.repositorio.RepositorioPagoCredito;
import com.ceiba.usuario.puerto.repositorio.RepositorioCredito;

import java.util.Calendar;
import java.util.Date;


public class ServicioPagorCredito {

    private final RepositorioPagoCredito repositorioPagoCredito;
    private final RepositorioCredito repositorioCredito;


    private static final String CREDITO_NO_ACTIVO = "El credito no esta activo";
    private static final String FECHA_INVALIDA = "La fecha de pago no puede ser menor a la fecha del credito";


    public ServicioPagorCredito(RepositorioPagoCredito repositorioPagoCredito, RepositorioCredito repositorioCredito) {

        this.repositorioPagoCredito = repositorioPagoCredito;
        this.repositorioCredito = repositorioCredito;

    }


    public Long ejecutar(PagoCredito pagoCredito) {

        Credito obtenerCredito = obtenerCreditoPago(pagoCredito.getIdCredito());

        validarVigenciaCredito(obtenerCredito.getEstado(), obtenerCredito.getFechaCredito(), pagoCredito.getFechaPago());

        Date fechaRealEntrega = validarfecha(pagoCredito.getFechaPago());

        asignarPago(obtenerCredito,pagoCredito,validarMora(fechaRealEntrega,obtenerCredito));

        return this.repositorioPagoCredito.crear(pagoCredito);
    }

    private Credito obtenerCreditoPago(Integer idCredito) {

        return this.repositorioCredito.obtenerCredito(idCredito);

    }

    private void validarVigenciaCredito(Boolean estado, Date fechaInicioCredito, Date fechaEnviada){

        if(!estado){

            throw new ExcepcionDuplicidad(CREDITO_NO_ACTIVO);

        }

        if(fechaInicioCredito.after(fechaEnviada)){

            throw new ExcepcionDuplicidad(FECHA_INVALIDA);

        }

    }

    public Date validarfecha(Date fechaCredito){

        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaCredito);

        int diaSemana = fecha.get(Calendar.DAY_OF_WEEK);

        if (diaSemana == Calendar.SUNDAY ) {

            fecha.add(Calendar.DAY_OF_MONTH, 1);

        }else if(diaSemana == Calendar.SATURDAY){

            fecha.add(Calendar.DAY_OF_MONTH, 2);

        }

        return fecha.getTime();

    }

    public Double validarMora(Date fechaRealEntrega, Credito credito){

        double valorInteresMora = 0d;

        int cuotaTotal = credito.getCuotasPagadas() + 1;

        Calendar fechaCredito = Calendar.getInstance();

        fechaCredito.setTime(credito.getFechaCredito());

        Calendar fechaRealEntregaCredito = Calendar.getInstance();

        fechaRealEntregaCredito.setTime(fechaRealEntrega);

        if(fechaCredito.get(Calendar.MONTH) != fechaRealEntregaCredito.get(Calendar.MONTH)){

            fechaCredito.add(Calendar.MONTH, cuotaTotal);

            Date FechaFeo = fechaCredito.getTime();

            long diff = fechaRealEntrega.getTime() - FechaFeo.getTime();
            long diffDays = diff / (24 * 60 * 60 * 1000);
            int daysdiff = (int) diffDays;


            if(fechaRealEntregaCredito.get(Calendar.MONTH) >= fechaCredito.get(Calendar.MONTH )){

                if(fechaRealEntregaCredito.get(Calendar.DAY_OF_MONTH ) > fechaCredito.get(Calendar.DAY_OF_MONTH ) ){

                    valorInteresMora = (credito.getValorCredito() / 100) * daysdiff;

                }

            }


        }


        return valorInteresMora;

    }

    private void asignarPago(Credito credito, PagoCredito pagoCredito,Double valorMora){

        double moraTotal = credito.getInteresMora() + valorMora;
        int cuotaTotal = credito.getCuotasPagadas() + 1;
        

        credito.setInteresMora(moraTotal);
        credito.setCuotasPagadas(cuotaTotal);

        /*Pago Total del credito = 1*/
        if(pagoCredito.getTipoPago().equals(1)){

            double valorActualDeuda = credito.getValorTotalPagar();
            double valorTotalPagado = valorActualDeuda + valorMora;
            double valorTotalPagar = 0;

            pagoCredito.setValorCuota(valorActualDeuda);
            pagoCredito.setValorMora(valorMora);
            credito.setValorTotalPagar(valorTotalPagar);
            credito.setValorTotalPagado(valorTotalPagado);
            credito.setEstado(false);

        }else{

            double valorActualDeuda = credito.getValorTotalPagar();
            double valorTotalPagar = valorActualDeuda - credito.getValorCuotas();
            double valorCuotaConMora =  credito.getValorCuotas() + valorMora;

            double valorTotalPagado = credito.getValorTotalPagado() + valorCuotaConMora;

            pagoCredito.setValorCuota(credito.getValorCuotas());
            pagoCredito.setValorMora(valorMora);
            credito.setValorTotalPagar(valorTotalPagar);
            credito.setValorTotalPagado(valorTotalPagado);


            if(credito.getValorTotalPagar() == 0){

                credito.setEstado(false);

            }


        }

        this.repositorioCredito.actualizar(credito);


    }

}
