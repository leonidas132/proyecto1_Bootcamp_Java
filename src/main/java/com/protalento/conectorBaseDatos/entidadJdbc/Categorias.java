package com.protalento.conectorBaseDatos.entidadJdbc;

public class Categorias {
     private Long id;
     private String descripcion;

    public Categorias() {
    }

    public Categorias(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categorias " +
                "id: " + id +
                " descripcion: " + descripcion ;
    }
}
