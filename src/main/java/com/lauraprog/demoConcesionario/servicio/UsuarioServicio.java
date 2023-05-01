package com.lauraprog.demoConcesionario.servicio;

import com.lauraprog.demoConcesionario.entity.Usuario;

import java.util.List;

public interface UsuarioServicio {

    public List<Usuario> encontrarTodos();
    public Usuario encontraPorId(int id);

    public void actualizarUsuario (Usuario usuario);

    public void crearUsuario(Usuario usuario);

    public void eliminarUsuario(int id);


}
