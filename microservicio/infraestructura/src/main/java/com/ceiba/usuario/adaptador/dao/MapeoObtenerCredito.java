package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.entidad.Credito;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;


public class MapeoObtenerCredito implements RowMapper<Credito>, MapperResult  {

    @Override
    public Credito mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Integer idUsuario = resultSet.getInt("idUsuario");
        Integer idTasa = resultSet.getInt("idTasa");
        Double valorCredito = resultSet.getDouble("valorCredito");
        Double valorCreditoInteres = resultSet.getDouble("valorCreditoInteres");
        Double valorTotalPagar = resultSet.getDouble("valorTotalPagar");
        Double valorTotalPagado = resultSet.getDouble("valorTotalPagado");
        Double valorCuotas = resultSet.getDouble("valorCuotas");
        Integer cuotasTotales = resultSet.getInt("cuotasTotales");
        Integer cuotasPagadas = resultSet.getInt("cuotasPagadas");
        Double interesMora = resultSet.getDouble("interesMora");
        Boolean estado = resultSet.getBoolean("estado");
        Date fechaCredito = resultSet.getDate("fechaCredito");


        return new Credito(id,idUsuario,idTasa,valorCredito,valorCreditoInteres,valorTotalPagar,valorTotalPagado,
                valorCuotas,cuotasTotales,cuotasPagadas,interesMora,estado,fechaCredito);
    }
}
