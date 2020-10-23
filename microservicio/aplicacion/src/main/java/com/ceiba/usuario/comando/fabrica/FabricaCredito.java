package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Credito;
import org.springframework.stereotype.Component;
import com.ceiba.usuario.comando.ComandoCredito;

//mapeo objeto

@Component
public class FabricaCredito {

    public Credito crear(ComandoCredito comandoCredito) {
        return new Credito(

                comandoCredito.getId(),
                comandoCredito.getIdUsuario(),
                comandoCredito.getIdTasa(),
                comandoCredito.getValorCredito(),
                comandoCredito.getValorCreditoInteres(),
                comandoCredito.getValorTotalPagar(),
                comandoCredito.getValorTotalPagado(),
                comandoCredito.getCuotasTotales(),
                comandoCredito.getCuotasPagadas(),
                comandoCredito.getInteresMora(),
                comandoCredito.getEstado(),
                comandoCredito.getFechaCredito()

        );
    }
}
