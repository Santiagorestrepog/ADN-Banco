package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Credito;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoCredito;

import java.time.LocalDateTime;

@Component
public class FabricaCredito {

    public Credito crear(ComandoCredito comandoCredito) {
        return new Credito(
                comandoCredito.getId(),
                comandoCredito.getValorCredito(),
                comandoCredito.getIdUsuario(),
                comandoCredito.getTipoCredito(),
                comandoCredito.getTasaInteres(),
                comandoCredito.getCuotasTotales(),
                comandoCredito.getCuotasPagadas(),
                comandoCredito.getEstado(),
                comandoCredito.getValorActual(),
                comandoCredito.getInteresMora(),
                comandoCredito.getFechacredito()


        );
    }
}
