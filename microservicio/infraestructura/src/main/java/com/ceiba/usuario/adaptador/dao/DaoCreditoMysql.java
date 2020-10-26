package com.ceiba.usuario.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.puerto.dao.DaoCredito;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoCredito;
import com.ceiba.usuario.modelo.dto.DtoTasa;

@Component
public class DaoCreditoMysql implements DaoCredito {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="credito", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="credito", value="listarTasa")
    private static String sqlListarTasa;



    public DaoCreditoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCredito> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCredito());
    }

    @Override
    public List<DtoTasa> listarTasaInteres() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarTasa, new MapeoTasa());
    }




}
