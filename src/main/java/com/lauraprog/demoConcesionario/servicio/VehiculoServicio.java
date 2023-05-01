package com.lauraprog.demoConcesionario.servicio;

import com.lauraprog.demoConcesionario.entity.Vehiculo;

import java.util.List;

public interface VehiculoServicio {

    public List<Vehiculo> encontrarTodos();

    public Vehiculo encontrarPorId(int id);

    public void actualizarVehiculo (Vehiculo vehiculo);

    public void crearVehiculo(Vehiculo vehiculo);

    public void eliminarVehiculo(int id);

}
