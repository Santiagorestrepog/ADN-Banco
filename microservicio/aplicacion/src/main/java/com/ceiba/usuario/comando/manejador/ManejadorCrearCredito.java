package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCredito;
import com.ceiba.usuario.comando.fabrica.FabricaCredito;
import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.servicio.ServicioCrearCredito;
import org.springframework.stereotype.Component;


@Component
public class ManejadorCrearCredito implements ManejadorComandoRespuesta<ComandoCredito, ComandoRespuesta<Long>>{

    private final FabricaCredito fabricaCredito;
    private final ServicioCrearCredito servicioCrearCredito;

    public ManejadorCrearCredito(FabricaCredito fabricaCredito, ServicioCrearCredito servicioCrearCredito) {
        this.fabricaCredito = fabricaCredito;
        this.servicioCrearCredito = servicioCrearCredito;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCredito comandoCredito) {
        Credito credito = this.fabricaCredito.crear(comandoCredito);
        return new ComandoRespuesta<>(this.servicioCrearCredito.ejecutar(credito));
    }

}
