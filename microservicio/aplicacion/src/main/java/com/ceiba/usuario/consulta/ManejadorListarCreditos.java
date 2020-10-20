package com.ceiba.usuario.consulta;

import java.util.List;
import com.ceiba.usuario.puerto.dao.DaoCredito;
import org.springframework.stereotype.Component;
import com.ceiba.usuario.modelo.dto.DtoCredito;

@Component
public class ManejadorListarCreditos {

    private final DaoCredito daoCredito;

    public ManejadorListarCreditos(DaoCredito daoCredito){
        this.daoCredito = daoCredito;
    }

    public List<DtoCredito> ejecutar(){ return this.daoCredito.listar(); }

}
