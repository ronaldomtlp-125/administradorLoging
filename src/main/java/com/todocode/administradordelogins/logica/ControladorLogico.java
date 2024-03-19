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
    private List<UsuarioCliente> traerUsuariosL() {
        return controlPersis.traerUsuariosP();
    }

    //Metodo reutilizable para modificar el objeto mensaje para la seccion de inicio
    public void settearMensaje(String contexto, String nombreUsuario, String rol) {
        mensaje.setMsContexto(contexto);
        mensaje.setMxNombreUsuario(nombreUsuario);
        mensaje.setMxRol(rol);
    }
}
