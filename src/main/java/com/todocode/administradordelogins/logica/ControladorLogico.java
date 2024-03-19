package com.todocode.administradordelogins.logica;

import com.todocode.administradordelogins.persistencia.ControladorPersistencia;
import java.util.List;

public class ControladorLogico {

    ControladorPersistencia controlPersis = new ControladorPersistencia();

    //Mensaje para el login
    public MensajeLogin traerMensajeLogin(String nombreUsuario, String contraseniaUsuario) {
        MensajeLogin mensaje = new MensajeLogin();
        List<UsuarioCliente> listaUsuarios = traerUsuariosL();

        for (UsuarioCliente usu : listaUsuarios) {
            if (usu.getUsuario().equals(nombreUsuario)) {
                if (usu.getContrasenia().equals(contraseniaUsuario)) {
                    mensaje.setMsContexto("acceso_permitido");
                    mensaje.setMxNombreUsuario(nombreUsuario);
                    mensaje.setMxRol(usu.getRol());
                    return mensaje;
                } else {
                    mensaje.setMsContexto("contraseña_incorrecta");
                    mensaje.setMxNombreUsuario(nombreUsuario);
                    mensaje.setMxRol("");
                }
            } else {
                mensaje.setMsContexto("usuario_incorrecto");
                mensaje.setMxNombreUsuario(nombreUsuario);
                mensaje.setMxRol("");
            }
        }
        return mensaje;
    }

    //Metodo reutilizable para traer toda la lista de registros de la tabla usuarios
    private List<UsuarioCliente> traerUsuariosL() {
        return controlPersis.traerUsuariosP();
    }

}
