package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoTasa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapeoTasa implements RowMapper<DtoTasa>, MapperResult {

    @Override
    public DtoTasa mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        Double tasa = resultSet.getDouble("tasa");



        return new DtoTasa(id,nombre,tasa);
    }
}
