package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.modelo.entidad.Usuario;

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

}
