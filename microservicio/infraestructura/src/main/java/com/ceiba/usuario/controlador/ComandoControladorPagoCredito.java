package com.ceiba.usuario.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.usuario.comando.ComandoPagoCredito;
import com.ceiba.usuario.comando.manejador.ManejadorCrearPagoCredito;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pago")
@Api(tags = { "Controlador comando pago"})
public class ComandoControladorPagoCredito {

    private final ManejadorCrearPagoCredito manejadorCrearPagoCredito;

    @Autowired
    public ComandoControladorPagoCredito(ManejadorCrearPagoCredito manejadorCrearPagoCredito) {

        this.manejadorCrearPagoCredito = manejadorCrearPagoCredito;

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    @ApiOperation("Crear Pago Credito")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPagoCredito comandoPagoCredito) {
        return manejadorCrearPagoCredito.ejecutar(comandoPagoCredito);
    }

}
