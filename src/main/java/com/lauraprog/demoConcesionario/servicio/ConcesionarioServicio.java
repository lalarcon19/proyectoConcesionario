package com.lauraprog.demoConcesionario.servicio;

import com.lauraprog.demoConcesionario.entity.Concesionario;

import java.util.List;


public interface ConcesionarioServicio {
    public List<Concesionario> encontrarTodos();

    public Concesionario encontrarPorId(int id);

    public void actualizarConcesionario (Concesionario concesionario);

    public void  crearConcesionario (Concesionario concesionario);

    public void eliminarConcesionario(int id);


}
