package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.puerto.repositorio.RepositorioCredito;
import java.util.Calendar;
import java.util.Date;


public class ServicioActualizarCredito {

    private final RepositorioCredito repositorioCredito;

    public ServicioActualizarCredito(RepositorioCredito repositorioCredito) {

        this.repositorioCredito = repositorioCredito;
    }

    public void ejecutar(Credito credito) {

        Date fechaActual = new Date();

        Date fechaRealEntrega = validarfecha(fechaActual);

        this.repositorioCredito.actualizar(validarMora(fechaRealEntrega,credito));

    }
    public Date validarfecha(Date fechaCredito){

        Calendar fecha = Calendar.getInstance();
        fecha.setTime(fechaCredito);

         int diaSemana = fecha.get(Calendar.DAY_OF_WEEK);

         if (diaSemana!=Calendar.SUNDAY ) {

             fecha.add(Calendar.DAY_OF_MONTH, 1);

         }else if(diaSemana != Calendar.SATURDAY){

             fecha.add(Calendar.DAY_OF_MONTH, 2);

         }

         return fecha.getTime();

    }

    public Credito validarMora(Date fechaRealEntrega, Credito credito){

        Calendar fechaCredito = Calendar.getInstance();
        fechaCredito.setTime(credito.getFechacredito());

        fechaCredito.add(Calendar.MONTH, credito.getCuotasPagadas());

        Calendar fechaRealEntregaCredito = Calendar.getInstance();
        fechaRealEntregaCredito.setTime(fechaRealEntrega);
        long diff = fechaRealEntrega.getTime() - credito.getFechacredito().getTime();
        long diffDays = diff / (24 * 60 * 60 * 1000) + 1;
        int daysdiff = (int) diffDays;


        if(fechaRealEntregaCredito.get(Calendar.DAY_OF_MONTH ) > fechaCredito.get(Calendar.DAY_OF_MONTH ) ){

           // Integer diasMora = fechaRealEntregaCredito.get(Calendar.DAY_OF_MONTH ) - fechaCredito.get(Calendar.DAY_OF_MONTH );

            double ValorInteresMora = (credito.getValorCredito() * credito.getTazaInteres()) / 100;
            double ValorActualIntereses = credito.getValorActual() + (ValorInteresMora * daysdiff);

            credito.setValorActual(ValorActualIntereses);

        }

        return credito;

    }


}
