package com.protalento.conectorBaseDatos.implementacion;

import com.protalento.conectorBaseDatos.entidadJdbc.Categorias;
import com.protalento.conectorBaseDatos.interfacesJdbc.ICategorias;

import java.util.List;

public class ImplCategorias implements ICategorias {
    @Override
    public Categorias buscarID(Long ID) {
        return null;
    }

    @Override
    public boolean insertar(Categorias categorias) {
        return false;
    }

    @Override
    public boolean modificar(Categorias categorias) {
        return false;
    }

    @Override
    public boolean eliminar(Categorias categorias) {
        return false;
    }

    @Override
    public List<Categorias> listar() {
        return null;
    }

}
