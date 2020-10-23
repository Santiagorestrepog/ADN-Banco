package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoPagoCredito;
import com.ceiba.usuario.modelo.entidad.PagoCredito;
import org.springframework.stereotype.Component;

//mapeo objeto

@Component
public class FabricaPagoCredito {

    public PagoCredito crear(ComandoPagoCredito comandoPagoCredito) {
        return new PagoCredito(

                comandoPagoCredito.getId(),
                comandoPagoCredito.getIdCredito(),
                comandoPagoCredito.getValorCuota(),
                comandoPagoCredito.getValorMora(),
                comandoPagoCredito.getFechaPago(),
                comandoPagoCredito.getTipoPago()

        );
    }

}
