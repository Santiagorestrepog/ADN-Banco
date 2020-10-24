package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Credito;

public interface RepositorioCredito {
    /**
     * Permite crear un credito
     * @param credito
     * @return el id generado
     */
    Long crear(Credito credito);


    /**
     * Permite validar si existe un credito con un usuario
     * @Param usuario
     * @param estado
     * @return si existe o no
     */
    boolean existe(Integer usuario, Boolean estado);

    /**
     * Permite actualizar un usuario
     * @param credito
     */
    void actualizar(Credito credito);

    /**
     * Permite buscar la tasa de interes de un credito
     * @param idTasa
     * @return valor tasa
     */
    double tasaInteres(Integer idTasa);

    /**
     * Permite crear un pago de credito
     * @param idCredito
     * @return creditos
     */
    Credito obtenerCredito(Integer idCredito);

}
