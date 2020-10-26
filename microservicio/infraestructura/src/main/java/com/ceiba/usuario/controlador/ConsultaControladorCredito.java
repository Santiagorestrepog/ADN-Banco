package com.ceiba.usuario.controlador;
import java.util.List;

import com.ceiba.usuario.consulta.ManejadorListarCreditos;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ceiba.usuario.modelo.dto.DtoCredito;
import com.ceiba.usuario.modelo.dto.DtoTasa;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/credito")
@Api(tags={"Controlador consulta credito"})


public class ConsultaControladorCredito {

    private final ManejadorListarCreditos manejadorListarCreditos;

    public ConsultaControladorCredito(ManejadorListarCreditos manejadorListarCreditos) {
        this.manejadorListarCreditos = manejadorListarCreditos;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ApiOperation("Listar credito")
    public List<DtoCredito> listar() {
        return this.manejadorListarCreditos.ejecutar();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    @ApiOperation("Listar tasa")
    @RequestMapping("/tasa")
    public List<DtoTasa> listarTasaInteres() {

        return this.manejadorListarCreditos.ejecutarTasa();
    }

}
