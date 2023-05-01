package com.lauraprog.demoConcesionario.implementacion;

import com.lauraprog.demoConcesionario.entity.Tipo_usuario;
import com.lauraprog.demoConcesionario.repository.RepositoryTipo_usuario;
import com.lauraprog.demoConcesionario.servicio.Tipo_usuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class Tipo_usuarioImpl implements Tipo_usuarioServicio {

    @Autowired
    RepositoryTipo_usuario repositoryTipo_usuario;

    @Override
    public List<Tipo_usuario> encontrarTodos() {
        return this.repositoryTipo_usuario.findAll();
    }

    @Override
    public  Tipo_usuario encontrarPorId(int id){
       return this.repositoryTipo_usuario.encontrarporId(id);
    }

    @Override
    public void actualizarTipo_usuario(Tipo_usuario tipo_usuario){
        if(tipo_usuario.getId()!=0) {
            this.repositoryTipo_usuario.save(tipo_usuario);
        }
    }

    @Override
    public void crearTipo_usuario(Tipo_usuario tipo_usuario){
        this.repositoryTipo_usuario.save(tipo_usuario);
    }

    @Override
    public void eliminarTipo_usuario(int id){
        Tipo_usuario tipo_usuario=this.repositoryTipo_usuario.encontrarporId(id);
        if (tipo_usuario!=null){
            this.repositoryTipo_usuario.delete(tipo_usuario);
        }

    }

}
