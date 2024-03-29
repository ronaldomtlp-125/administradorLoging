package com.todocode.administradordelogins.logica;

import com.todocode.administradordelogins.persistencia.ControladorPersistencia;
import java.util.List;

public class ControladorLogico {

    MensajeLogin mensaje = new MensajeLogin();
    ControladorPersistencia controlPersis = new ControladorPersistencia();

    //Mensaje para el login
    public MensajeLogin traerMensajeLogin(String nombreUsuario, String contraseniaUsuario) {
        List<UsuarioCliente> listaUsuarios = traerUsuariosL();

        for (UsuarioCliente usu : listaUsuarios) {
            if (usu.getUsuario().equals(nombreUsuario)) {
                if (usu.getContrasenia().equals(contraseniaUsuario)) {
                    settearMensaje("acceso_permitido", nombreUsuario, usu.getRol());
                    return mensaje;
                } else {
                    settearMensaje("contraseña_incorrecta", nombreUsuario, "");
                    return mensaje;
                }
            } else {
                settearMensaje("usuario_incorrecto", nombreUsuario, "");
            }
        }
        return mensaje;
    }

    //Metodo reutilizable para traer toda la lista de registros de la tabla usuarios
    public List<UsuarioCliente> traerUsuariosL() {
        return controlPersis.traerUsuariosP();
    }

    //Metodo reutilizable para modificar el objeto mensaje para la seccion de inicio
    private void settearMensaje(String contexto, String nombreUsuario, String rol) {
        mensaje.setMsContexto(contexto);
        mensaje.setMxNombreUsuario(nombreUsuario);
        mensaje.setMxRol(rol);
    }

    public void borrarRegistroL(int idUsuario) {
        controlPersis.borrarRegistroP(idUsuario);
    }

    public void crearUsuarioL(String nombreUsu, String contraseniaUsu, String rolUsu) {
        UsuarioCliente usuarioAux = new UsuarioCliente(nombreUsu, contraseniaUsu, rolUsu);
        controlPersis.crearUsuarioP(usuarioAux);
    }

    public boolean existeUsuario(String nombreUsu) {
        boolean existeAux = false;
        List<UsuarioCliente> listaAux = traerUsuariosL();
        for(UsuarioCliente usu : listaAux){
            if(usu.getUsuario().equalsIgnoreCase(nombreUsu)){
                existeAux = true;
                return existeAux;
            } else{
                existeAux = false;
            }
        }
        return existeAux;
    }
    
    //Metodo reutilizable para traer un usuario de la base de datos
    public UsuarioCliente traerUsuarioL(int idUsuario) {
        return controlPersis.traerUsuarioP(idUsuario);
    }

    public void editarRegistroL(UsuarioCliente usuario, String nombreUsu, String contraseniaUsu, String rolUsu) {
        usuario.setUsuario(nombreUsu);
        usuario.setContrasenia(contraseniaUsu);
        usuario.setRol(rolUsu);
        controlPersis.editarRegistroP(usuario);
    }
}
