package com.todocode.administradordelogins;

import com.todocode.administradordelogins.igu.Inicio;
import com.todocode.administradordelogins.igu.VerRegistrosAdmin;

public class AdministradorDeLogins {

    public static void main(String[] args) {
        Inicio inicio = new Inicio();
        //CrearRegistro creaRegistro = new CrearRegistro();
        //EditarRegistro editarRegistro = new EditarRegistro();
        VerRegistrosAdmin registroAdmin = new VerRegistrosAdmin();
        //VerRegistrosUsu registroUsu = new VerRegistrosUsu();
        registroAdmin.setVisible(true);
        registroAdmin.setLocationRelativeTo(null);
    } 
}
