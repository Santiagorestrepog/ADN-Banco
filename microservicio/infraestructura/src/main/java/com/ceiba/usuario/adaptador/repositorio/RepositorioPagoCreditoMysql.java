package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.PagoCredito;
import org.springframework.stereotype.Repository;
import com.ceiba.usuario.puerto.repositorio.RepositorioPagoCredito;

@Repository
public class RepositorioPagoCreditoMysql implements RepositorioPagoCredito {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pagoCredito", value="crear")
    private static String sqlCrear;


    public RepositorioPagoCreditoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(PagoCredito pagoCredito) {

        return this.customNamedParameterJdbcTemplate.crear(pagoCredito, sqlCrear);

    }


}
