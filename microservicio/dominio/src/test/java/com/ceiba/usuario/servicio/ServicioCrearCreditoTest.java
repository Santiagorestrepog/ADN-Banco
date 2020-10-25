package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.puerto.repositorio.RepositorioCredito;
import com.ceiba.usuario.servicio.testdatabuilder.CreditoTestDataBuilder;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearCreditoTest {

    @Test
    public void calcularInteres() {
        //arrange
        Double ValorEsperado = 105000.0;
        Credito credito = new CreditoTestDataBuilder().build();
        RepositorioCredito repositorioCredito = Mockito.mock(RepositorioCredito.class);
        Mockito.when(repositorioCredito.existe(Mockito.anyInt(),Mockito.anyBoolean())).thenReturn(false);
        Mockito.when(repositorioCredito.tasaInteres(Mockito.anyInt())).thenReturn(5.0);
        ServicioCrearCredito servicioCrearCredito = new ServicioCrearCredito(repositorioCredito);
        //act - assert
        servicioCrearCredito.ejecutar(credito);

        Assert.assertEquals( ValorEsperado ,credito.getValorCreditoInteres());

    }


    @Test
    public void validarCreditoVigente() {
        // arrange
        Credito credito = new CreditoTestDataBuilder().build();
        RepositorioCredito repositorioCredito = Mockito.mock(RepositorioCredito.class);
        Mockito.when(repositorioCredito.existe(Mockito.anyInt(),Mockito.anyBoolean())).thenReturn(true);
        ServicioCrearCredito servicioCrearCredito = new ServicioCrearCredito(repositorioCredito);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCredito.ejecutar(credito), ExcepcionDuplicidad.class,"El usuario tiene un credito vigente");
    }

    @Test
    public void sinCreditosVigentes(){

        // arrange
        Credito credito = new CreditoTestDataBuilder().build();
        RepositorioCredito repositorioCredito = Mockito.mock(RepositorioCredito.class);
        Mockito.when(repositorioCredito.existe(Mockito.anyInt(),Mockito.anyBoolean())).thenReturn(false);
        ServicioCrearCredito servicioCrearCredito = new ServicioCrearCredito(repositorioCredito);
        // act - assert

        servicioCrearCredito.ejecutar(credito);

        Assert.assertTrue(true);

    }

    @Test
    public void calcularCuota() {
        //arrange
        Double ValorEsperado = 35000.0;
        Credito credito = new CreditoTestDataBuilder().build();
        RepositorioCredito repositorioCredito = Mockito.mock(RepositorioCredito.class);
        Mockito.when(repositorioCredito.existe(Mockito.anyInt(),Mockito.anyBoolean())).thenReturn(false);
        Mockito.when(repositorioCredito.tasaInteres(Mockito.anyInt())).thenReturn(5.0);
        ServicioCrearCredito servicioCrearCredito = new ServicioCrearCredito(repositorioCredito);
        //act - assert
        servicioCrearCredito.ejecutar(credito);

        Assert.assertEquals( ValorEsperado ,credito.getValorCuotas());

    }
}
