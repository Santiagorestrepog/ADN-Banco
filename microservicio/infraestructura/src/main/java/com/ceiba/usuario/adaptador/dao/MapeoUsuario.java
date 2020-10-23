package com.ceiba.usuario.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String apellidos = resultSet.getString("apellidos");
        String cedula = resultSet.getString("cedula");
        String tipoDocumento = resultSet.getString("tipoDocumento");
        String correo = resultSet.getString("correo");
        Date fechaCreacion = resultSet.getDate("fechaCreacion");

        return new DtoUsuario(id,nombre,apellidos,cedula,tipoDocumento,correo,fechaCreacion);
    }



}
