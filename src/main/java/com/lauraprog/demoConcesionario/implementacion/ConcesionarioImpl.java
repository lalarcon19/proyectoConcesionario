package com.lauraprog.demoConcesionario.implementacion;

import com.lauraprog.demoConcesionario.entity.Concesionario;
import com.lauraprog.demoConcesionario.repository.RepositoryConcesionario;
import com.lauraprog.demoConcesionario.servicio.ConcesionarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcesionarioImpl implements ConcesionarioServicio {

    @Autowired
    RepositoryConcesionario repositoryConcesionario;

    @Override
    public List<Concesionario> encontrarTodos(){
        return this.repositoryConcesionario.findAll();
    }

    @Override
    public Concesionario encontrarPorId(int id){

        return this.repositoryConcesionario.encontrarporId(id);
    }

    @Override
    public void actualizarConcesionario(Concesionario concesionario) {
        if (concesionario.getId() != 0) {
            this.repositoryConcesionario.save(concesionario);
        }
    }

    @Override
    public void crearConcesionario(Concesionario concesionario){

        this.repositoryConcesionario.save(concesionario);
    }

    @Override
    public void eliminarConcesionario(int id){
        Concesionario concesionario=this.repositoryConcesionario.encontrarporId(id);
        if (concesionario!=null){
            this.repositoryConcesionario.delete(concesionario);
        }

    }

}
