package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoPagoCredito;
import com.ceiba.usuario.comando.fabrica.FabricaPagoCredito;
import com.ceiba.usuario.modelo.entidad.PagoCredito;
import com.ceiba.usuario.servicio.ServicioCrearPagoCredito;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPagoCredito implements ManejadorComandoRespuesta<ComandoPagoCredito, ComandoRespuesta<Long>>{

    private final FabricaPagoCredito fabricaPagoCredito;
    private final ServicioCrearPagoCredito servicioCrearPagoCredito;

    public ManejadorCrearPagoCredito(FabricaPagoCredito fabricaPagoCredito, ServicioCrearPagoCredito servicioCrearPagoCredito) {
        this.fabricaPagoCredito = fabricaPagoCredito;
        this.servicioCrearPagoCredito = servicioCrearPagoCredito;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPagoCredito comandoPagoCredito) {
        PagoCredito pagoCredito = this.fabricaPagoCredito.crear(comandoPagoCredito);
        return new ComandoRespuesta<>(this.servicioCrearPagoCredito.ejecutar(pagoCredito));
    }

}
