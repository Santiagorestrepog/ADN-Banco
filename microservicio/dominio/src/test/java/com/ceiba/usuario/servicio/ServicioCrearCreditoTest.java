package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.puerto.repositorio.RepositorioCredito;
import com.ceiba.usuario.servicio.testdatabuilder.CreditoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearCreditoTest {


    @Test
    public void validarExistenciaPreviaCreditoTest() {
        // arrange
        Credito credito = new CreditoTestDataBuilder().build();
        RepositorioCredito repositorioCredito = Mockito.mock(RepositorioCredito.class);
        Mockito.when(repositorioCredito.existe(Mockito.anyInt(),Mockito.anyBoolean())).thenReturn(true);
        ServicioCrearCredito servicioCrearCredito = new ServicioCrearCredito(repositorioCredito);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCredito.ejecutar(credito), ExcepcionDuplicidad.class,"El usuario tiene un credito vigente");
    }
}
