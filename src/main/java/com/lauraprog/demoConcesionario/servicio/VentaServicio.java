package com.lauraprog.demoConcesionario.servicio;

import com.lauraprog.demoConcesionario.entity.Venta;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaServicio {

    public List<Venta>encontrarTodos();

    public Venta encontrarPorId(int id);

    public void actualizarVenta(Venta venta);

    public void crearVenta(Venta venta);

    public void eliminarVenta(int id);
}
