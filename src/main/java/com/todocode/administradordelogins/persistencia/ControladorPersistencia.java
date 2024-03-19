package com.todocode.administradordelogins.persistencia;

import com.todocode.administradordelogins.logica.UsuarioCliente;
import java.util.List;

public class ControladorPersistencia {
    UsuarioClienteJpaController usuJpa = new UsuarioClienteJpaController();

    public List<UsuarioCliente> traerUsuariosP() {
        return usuJpa.findUsuarioClienteEntities();
    }

}
