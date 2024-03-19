package com.todocode.administradordelogins.persistencia;

import com.todocode.administradordelogins.logica.UsuarioCliente;
import com.todocode.administradordelogins.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorPersistencia {
    UsuarioClienteJpaController usuJpa = new UsuarioClienteJpaController();

    public List<UsuarioCliente> traerUsuariosP() {
        return usuJpa.findUsuarioClienteEntities();
    }

    public void borrarRegistroP(int idUsuario) {
        try {
            usuJpa.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void crearUsuarioP(UsuarioCliente usuarioAux) {
        usuJpa.create(usuarioAux);
    }

    public UsuarioCliente traerUsuarioP(int idUsuario) {
        return usuJpa.findUsuarioCliente(idUsuario);
    }

    public void editarRegistroP(UsuarioCliente usuario) {
        try {
            usuJpa.edit(usuario);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
