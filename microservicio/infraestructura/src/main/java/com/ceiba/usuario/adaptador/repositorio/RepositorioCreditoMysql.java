package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.adaptador.dao.MapeoObtenerCredito;
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

    @SqlStatement(namespace="credito", value="existeCredito")
    private static String sqlExisteCredito;

    @SqlStatement(namespace="credito", value="tasaInteres")
    private static String sqlTasaInteres;

    @SqlStatement(namespace="credito", value="obtenerCredito")
    private static String sqlObtenerCredito;


    public RepositorioCreditoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Credito credito) {

        return this.customNamedParameterJdbcTemplate.crear(credito, sqlCrear);

    }

    @Override
    public boolean existe(Integer usuario, Boolean estado) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idUsuario", usuario);
        paramSource.addValue("estado", estado);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCredito,paramSource, Boolean.class);

    }

    @Override
    public void actualizar(Credito credito) {
        this.customNamedParameterJdbcTemplate.actualizar(credito, sqlActualizar);
    }

    @Override
    public double tasaInteres(Integer idTasa) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idTasa", idTasa);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlTasaInteres,paramSource, Double.class);

    }

    @Override
    public Credito obtenerCredito(Integer idCredito){

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idCredito", idCredito);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerCredito,paramSource, new MapeoObtenerCredito());

    }



}
