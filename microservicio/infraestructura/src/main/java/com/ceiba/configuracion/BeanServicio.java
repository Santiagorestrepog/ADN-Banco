package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioCredito;
import com.ceiba.usuario.puerto.repositorio.RepositorioPagoCredito;
import com.ceiba.usuario.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearCredito servicioCrearCredito(RepositorioCredito repositorioCredito) {
        return  new ServicioCrearCredito(repositorioCredito);
    }

    @Bean
    public ServicioActualizarCredito servicioActualizarCredito(RepositorioCredito repositorioCredito) {
        return  new ServicioActualizarCredito(repositorioCredito);
    }

    @Bean
    public ServicioPagorCredito servicioCrearPagoCredito(RepositorioPagoCredito repositorioPagoCredito, RepositorioCredito repositorioCredito) {
        return  new ServicioPagorCredito(repositorioPagoCredito, repositorioCredito );
    }
	

}
