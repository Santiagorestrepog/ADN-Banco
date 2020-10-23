package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoCredito;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarCredito;
import com.ceiba.usuario.comando.manejador.ManejadorCrearCredito;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/credito")
@Api(tags = { "Controlador comando credito"})
public class ComandoControladorCredito {

    private final ManejadorCrearCredito manejadorCrearCredito;
    private final ManejadorActualizarCredito manejadorActualizarCredito;

    @Autowired
    public ComandoControladorCredito(ManejadorCrearCredito manejadorCrearCredito,
                                     ManejadorActualizarCredito manejadorActualizarCredito) {

        this.manejadorCrearCredito = manejadorCrearCredito;
        this.manejadorActualizarCredito = manejadorActualizarCredito;

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ApiOperation("Crear credito")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCredito comandoCredito) {
        return manejadorCrearCredito.ejecutar(comandoCredito);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Pago Credito")
    public void actualizar(@RequestBody ComandoCredito comandoCredito,@PathVariable Long id) {
        comandoCredito.setId(id);
        manejadorActualizarCredito.ejecutar(comandoCredito);
    }

}
