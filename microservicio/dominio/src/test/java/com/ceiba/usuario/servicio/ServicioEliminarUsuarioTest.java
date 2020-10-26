package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioCredito;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.servicio.testdatabuilder.CreditoTestDataBuilder;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioEliminarUsuarioTest {

    @Test
    public void validarUsuarioCredito() {
         //arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1l).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        ServicioEliminarUsuario servicioEliminarUsuario = new ServicioEliminarUsuario(repositorioUsuario);
        Mockito.when(repositorioUsuario.existeUsuarioCredito(Mockito.anyLong())).thenReturn(true);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarUsuario.ejecutar(usuario.getId()), ExcepcionDuplicidad.class,"El usuario tiene un credito activo");
    }


}
