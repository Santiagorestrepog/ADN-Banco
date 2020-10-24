package com.ceiba.usuario.comando.manejador;

import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.servicio.ServicioActualizarCredito;
import org.springframework.stereotype.Component;
import com.ceiba.usuario.comando.ComandoCredito;
import com.ceiba.usuario.comando.fabrica.FabricaCredito;

@Component
public class ManejadorActualizarCredito {

    private final FabricaCredito fabricaCredito;
    private final ServicioActualizarCredito servicioActualizarCredito;

    public ManejadorActualizarCredito(FabricaCredito fabricaCredito, ServicioActualizarCredito servicioActualizarCredito) {
        this.fabricaCredito = fabricaCredito;
        this.servicioActualizarCredito = servicioActualizarCredito;
    }

    public void ejecutar(ComandoCredito comandoCredito) {
        Credito credito = this.fabricaCredito.crear(comandoCredito);


        this.servicioActualizarCredito.ejecutar(credito);
    }



}
