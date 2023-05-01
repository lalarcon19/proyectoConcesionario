package com.lauraprog.demoConcesionario.implementacion;

import com.lauraprog.demoConcesionario.entity.Usuario;
import com.lauraprog.demoConcesionario.servicio.UsuarioServicio;
import com.lauraprog.demoConcesionario.repository.RepositoryUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioImpl implements UsuarioServicio{

    @Autowired
    RepositoryUsuario repositoryUsuario;

    @Override
    public List<Usuario> encontrarTodos() {
        return this.repositoryUsuario.findAll();
    }

    @Override
    public Usuario encontraPorId(int id)   {

        return this.repositoryUsuario.encontraporId(id);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        if(usuario.getId()!=0) {
            this.repositoryUsuario.save(usuario);
        }
    }

    @Override
    public void crearUsuario(Usuario usuario) {
        this.repositoryUsuario.save(usuario);

    }

    @Override
    public void eliminarUsuario(int id) {
        Usuario usuario=this.repositoryUsuario.encontraporId(id);
        if (usuario!=null){
            this.repositoryUsuario.delete(usuario);
        }

    }
}
