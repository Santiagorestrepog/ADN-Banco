package com.ceiba.usuario.servicio;

import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.puerto.repositorio.RepositorioPagoCredito;
import com.ceiba.usuario.puerto.repositorio.RepositorioCredito;
import com.ceiba.usuario.servicio.testdatabuilder.CreditoTestDataBuilder;
import org.junit.Test;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServicioPagoCreditoTest {

    @Test
    public void obtenerFechaReal() throws ParseException {

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaPago = format.parse("2020-10-15");
        Date fechaEsteparda = format.parse("2020-10-15");

        RepositorioPagoCredito repositorioPagoCredito = mock(RepositorioPagoCredito.class);
        RepositorioCredito repositorioCredito = mock(RepositorioCredito.class);
        ServicioPagorCredito servicioPagorCredito = new ServicioPagorCredito(repositorioPagoCredito, repositorioCredito);

        // act
        Date fecha = servicioPagorCredito.validarfecha(fechaPago);

        //assert
        assertEquals(fechaEsteparda,fecha );

    }

    @Test
    public void obtenerFechaRealNoHabil() throws ParseException{

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaPago = format.parse("2020-10-17");
        Date fechaEsteparda = format.parse("2020-10-19");

        RepositorioPagoCredito repositorioPagoCredito = mock(RepositorioPagoCredito.class);
        RepositorioCredito repositorioCredito = mock(RepositorioCredito.class);
        ServicioPagorCredito servicioPagorCredito = new ServicioPagorCredito(repositorioPagoCredito, repositorioCredito);

        // act
        Date fecha = servicioPagorCredito.validarfecha(fechaPago);

        //assert
        assertEquals(fechaEsteparda,fecha );

    }

    @Test
    public void validarSinMora() throws ParseException{

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaPago = format.parse("2020-10-14");
        Date fechaInicioCredito = format.parse("2020-09-14");
        Double valorEsperado = 0d;

        Credito credito = new CreditoTestDataBuilder().build();
        credito.setFechaCredito(fechaInicioCredito);
        RepositorioPagoCredito repositorioPagoCredito = mock(RepositorioPagoCredito.class);
        RepositorioCredito repositorioCredito = mock(RepositorioCredito.class);
        ServicioPagorCredito servicioPagorCredito = new ServicioPagorCredito(repositorioPagoCredito, repositorioCredito);

        // act
        Double mora = servicioPagorCredito.validarMora(fechaPago,credito);

        //assert
        assertEquals(valorEsperado, mora );

    }

    @Test
    public void validarConMora() throws ParseException{

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaPago = format.parse("2020-10-20");
        Date fechaInicioCredito = format.parse("2020-09-17");
        Double valorEsperado = 3000d;

        Credito credito = new CreditoTestDataBuilder().build();
        credito.setFechaCredito(fechaInicioCredito);
        RepositorioPagoCredito repositorioPagoCredito = mock(RepositorioPagoCredito.class);
        RepositorioCredito repositorioCredito = mock(RepositorioCredito.class);
        ServicioPagorCredito servicioPagorCredito = new ServicioPagorCredito(repositorioPagoCredito, repositorioCredito);

        // act
        Double mora = servicioPagorCredito.validarMora(fechaPago,credito);

        //assert
        assertEquals(valorEsperado, mora );

    }

}
