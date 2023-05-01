package com.lauraprog.demoConcesionario.implementacion;

import com.lauraprog.demoConcesionario.entity.Vehiculo;
import com.lauraprog.demoConcesionario.repository.RepositoryVehiculo;
import com.lauraprog.demoConcesionario.servicio.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoImpl implements VehiculoServicio {

    @Autowired
    RepositoryVehiculo repositoryVehiculo;

    @Override
    public List<Vehiculo> encontrarTodos(){
        return this.repositoryVehiculo.findAll();
    }

    @Override
    public Vehiculo encontrarPorId(int id){
        return this.repositoryVehiculo.encontrarporId(id);
    }

    @Override
    public void actualizarVehiculo(Vehiculo vehiculo){
        if(vehiculo.getId()!=0){
            this.repositoryVehiculo.save(vehiculo);
        }
    }

    @Override
    public  void crearVehiculo(Vehiculo vehiculo) {
        this.repositoryVehiculo.save(vehiculo);
    }

    @Override
    public void eliminarVehiculo(int id){
    Vehiculo vehiculo=this.repositoryVehiculo.encontrarporId(id);
    if (vehiculo!=null){
        this.repositoryVehiculo.delete(vehiculo);
      }
    }
}
