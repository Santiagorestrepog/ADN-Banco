package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Credito;
import com.ceiba.usuario.puerto.repositorio.RepositorioCredito;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCreditoMysql implements RepositorioCredito {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="credito", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="credito", value="actualizar")
    private static String sqlActualizar;

    public RepositorioCreditoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long crear(Credito credito) {
        return this.customNamedParameterJdbcTemplate.crear(credito, sqlCrear);
    }

    @Override
    public boolean existe(Integer usuario, Boolean estado) {
        return false;
    }


    @Override
    public void actualizar(Credito credito) {
        this.customNamedParameterJdbcTemplate.actualizar(credito, sqlActualizar);
    }



}
