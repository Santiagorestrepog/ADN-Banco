package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoCredito;
import com.ceiba.usuario.modelo.dto.DtoTasa;

import java.util.List;

public interface DaoCredito {

    /**
     * Permite listar creditos
     * @return los credito
     */
    List<DtoCredito> listar();

    /**
     * Permite listar tasa
     * @return los credito
     */
    List<DtoTasa> listarTasaInteres();
}
