package com.protalento.conectorBaseDatos.entidadPrueva;

public class UsuarioPrueba {
    private String correo;

    public UsuarioPrueba() {
    }

    public UsuarioPrueba(String correo) {
        this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "UsuarioPrueba{" +
                "correo='" + correo + '\'' +
                '}';
    }
}
