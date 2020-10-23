package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;

@Component
public class FabricaUsuario {

    public Usuario crear(ComandoUsuario comandoUsuario) {
        return new Usuario(
                comandoUsuario.getId(),
                comandoUsuario.getNombre(),
                comandoUsuario.getApellidos(),
                comandoUsuario.getCedula(),
                comandoUsuario.getTipoDocumento(),
                comandoUsuario.getCorreo(),
                comandoUsuario.getFechaCreacion()
        );
    }

}
