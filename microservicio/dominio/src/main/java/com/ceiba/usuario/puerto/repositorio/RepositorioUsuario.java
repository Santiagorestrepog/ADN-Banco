package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioUsuario {

    /**
     * Permite crear un usuario
     * @param usuario
     * @return el id generado
     */
    Long crear(Usuario usuario);

    /**
     * Permite validar si existe un usuario con una cedula
     * @param cedula
     * @return si existe o no
     */
    boolean existe(String cedula);

    /**
     * Permite validar si existe un usuario con credito activo
     * @param idUsuario
     * @return si existe o no
     */
    boolean existeUsuarioCredito(Long idUsuario);

    /**
     * Permite eliminar un usuario
     * @param id
     *  @return respuesta
     */
    void eliminar(Long id);

    /**
     * Permite actualizar un usuario
     * @param usuario
     */
    void actualizar(Usuario usuario);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @param cedula
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String cedula);

}
