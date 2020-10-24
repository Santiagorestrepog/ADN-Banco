package com.ceiba.usuario.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.comando.ComandoPagoCredito;
import com.ceiba.usuario.comando.fabrica.FabricaPagoCredito;
import com.ceiba.usuario.modelo.entidad.PagoCredito;
import com.ceiba.usuario.servicio.ServicioPagorCredito;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPagoCredito implements ManejadorComandoRespuesta<ComandoPagoCredito, ComandoRespuesta<Long>>{

    private final FabricaPagoCredito fabricaPagoCredito;
    private final ServicioPagorCredito servicioPagorCredito;

    public ManejadorCrearPagoCredito(FabricaPagoCredito fabricaPagoCredito, ServicioPagorCredito servicioPagorCredito) {
        this.fabricaPagoCredito = fabricaPagoCredito;
        this.servicioPagorCredito = servicioPagorCredito;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPagoCredito comandoPagoCredito) {
        PagoCredito pagoCredito = this.fabricaPagoCredito.crear(comandoPagoCredito);
        return new ComandoRespuesta<>(this.servicioPagorCredito.ejecutar(pagoCredito));
    }

}
