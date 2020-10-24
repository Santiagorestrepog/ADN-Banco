package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.PagoCredito;

public interface RepositorioPagoCredito {

    /**
     * Permite crear un pago de credito
     * @param pagoCredito
     * @return el id generado
     */
    Long crear(PagoCredito pagoCredito);


}
