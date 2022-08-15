package com.protalento.conectorBaseDatos.implementacion;

import com.protalento.conectorBaseDatos.conexion.Conexion;
import com.protalento.conectorBaseDatos.entidadJdbc.User;
import com.protalento.conectorBaseDatos.interfacesJdbc.IUsuario;
import com.protalento.conectorBaseDatos.utilidades.Fechas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ImplUsuario implements IUsuario {
    private PreparedStatement preparedStatementBuscarId
    private PreparedStatement preparedStatementInsertar;
    private PreparedStatement preparedStatementModificar;
    private PreparedStatement preparedStatementEliminar;
    private PreparedStatement preparedStatementListar;
    private PreparedStatement preparedStatementBuscarCorreoClave;
    private Conexion conexion;

    public ImplUsuario() {
       conexion = new Conexion();
    }

    @Override
    public User buscarID(String correo) {
        User user = null;
        String sql = "select aes_encrypt(clave,?) as clave,fechaCreacion,fechaUltimoAcceso from usuarios where correo=?";
        try {
            if (null== preparedStatementBuscarId) {
                preparedStatementBuscarId = conexion.conexiondb().prepareStatement(sql);
            }
            preparedStatementBuscarId.setString(1, conexion.getLlave());
            preparedStatementBuscarId.setString(2,correo);

            ResultSet resultSet = preparedStatementBuscarId.executeQuery();
            if(resultSet.next()) {
                user = new User();
                user.setCorreo(correo);
                user.setClave(resultSet.getString("clave"));
                user.setFechaCreacion(Fechas.getLocalDate(resultSet.getString("fechaCreacion")));
                user.setFechaUltimoAcceso(Fechas.getLocalDateTime(resultSet.getString("fechaUltimoAcceso")));
                user.setCorreo(correo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public boolean insertar(User user) {
        String sql = "insert into usuarios(correo,clave,fechaCreacion,fechaUltimoAcceso) values(?,aes_encrypt(?,?),?,?)";
        try {
            if(null==preparedStatementInsertar) {
                preparedStatementInsertar = conexion.conexiondb().prepareStatement(sql);
            }
            preparedStatementInsertar.setString(1,user.getCorreo());
            preparedStatementInsertar.setString(2,user.getClave());
            preparedStatementInsertar.setString(3, conexion.getLlave());
            preparedStatementInsertar.setString(4,Fechas.getString(user.getFechaCreacion()));
            preparedStatementInsertar.setString(5,Fechas.getString(user.getFechaUltimoAcceso()));

            return preparedStatementInsertar.executeUpdate()==1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean modificar(User user) {
        return false;
    }

    @Override
    public boolean eliminar(User user) {
        return false;
    }

    @Override
    public List<User> listar() {
        return null;
    }

    @Override
    public User buscarPorCorreoClave(String correo, String clave) {
        User user = null;

        String sql = "select fechaCreacion,fechaUltimoAcceso from usuarios where correo=? and aes_encrypt(clave,?) = ? ";
        try {
            if (null== preparedStatementBuscarCorreoClave) {
                preparedStatementBuscarCorreoClave = conexion.conexiondb().prepareStatement(sql);
            }

            preparedStatementBuscarCorreoClave.setString(1,correo);
            preparedStatementBuscarCorreoClave.setString(2, conexion.getLlave());
            preparedStatementBuscarCorreoClave.setString(3,clave);

            ResultSet resultSet = preparedStatementBuscarCorreoClave.executeQuery();
            if(resultSet.next()) {
                user = new User();
                user.setCorreo(correo);
                user.setClave("clave");
                user.setFechaCreacion(Fechas.getLocalDate(resultSet.getString("fechaCreacion")));
                user.setFechaUltimoAcceso(Fechas.getLocalDateTime(resultSet.getString("fechaUltimoAcceso")));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    }


}
