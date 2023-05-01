package com.lauraprog.demoConcesionario.servicio;

import com.lauraprog.demoConcesionario.entity.Tipo_usuario;

import java.util.List;

public interface Tipo_usuarioServicio {

    public List<Tipo_usuario> encontrarTodos();

    public Tipo_usuario encontrarPorId(int id);

    public void actualizarTipo_usuario(Tipo_usuario tipo_usuario);

    public void crearTipo_usuario (Tipo_usuario tipo_usuario);

    public void eliminarTipo_usuario(int id);



}
