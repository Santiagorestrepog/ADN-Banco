package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoCredito;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

public class MapeoCredito implements RowMapper<DtoCredito>, MapperResult {

    @Override
    public DtoCredito mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Double valorCredito = resultSet.getDouble("valorCredito");
        Integer idUsuario = resultSet.getInt("idUsuario");
        String tipoCredito = resultSet.getString("tipoCredito");
        Integer tazaInteres = resultSet.getInt("tazaInteres");
        Integer cuotasTotales = resultSet.getInt("cuotasTotales");
        Integer cuotasPagadas = resultSet.getInt("cuotasPagadas");
        Boolean estado = resultSet.getBoolean("estado");
        Double valorActual = resultSet.getDouble("valorActual");
        Double interesMora = resultSet.getDouble("interesMora");
        Date fechacredito = resultSet.getDate("fechacredito");

        return new DtoCredito(id,valorCredito,idUsuario,tipoCredito,tazaInteres,cuotasTotales,cuotasPagadas,estado,valorActual,interesMora,fechacredito);
    }
}
