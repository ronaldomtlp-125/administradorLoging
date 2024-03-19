package com.todocode.administradordelogins.logica;

public class MensajeLogin {

    private String msContexto;
    private String mxNombreUsuario;
    private String mxRol;

    public MensajeLogin() {
    }

    public String getMsContexto() {
        return msContexto;
    }

    public void setMsContexto(String msContexto) {
        this.msContexto = msContexto;
    }

    public String getMxNombreUsuario() {
        return mxNombreUsuario;
    }

    public void setMxNombreUsuario(String mxNombreUsuario) {
        this.mxNombreUsuario = mxNombreUsuario;
    }

    public String getMxRol() {
        return mxRol;
    }

    public void setMxRol(String mxRol) {
        this.mxRol = mxRol;
    }

}
