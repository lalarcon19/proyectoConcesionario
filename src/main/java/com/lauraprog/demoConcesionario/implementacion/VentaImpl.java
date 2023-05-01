package com.lauraprog.demoConcesionario.implementacion;

import com.lauraprog.demoConcesionario.entity.Venta;
import com.lauraprog.demoConcesionario.repository.RepositoryVenta;
import com.lauraprog.demoConcesionario.servicio.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaImpl implements VentaServicio {

   @Autowired
    RepositoryVenta repositoryVenta;

   @Override
    public List<Venta> encontrarTodos(){
       return this.repositoryVenta.findAll();
   }

   @Override
    public Venta encontrarPorId(int id){
       return this.repositoryVenta.encontrarporId(id);
   }

   @Override
    public void actualizarVenta(Venta venta){
       if (venta.getId()!=0) {
           this.repositoryVenta.save(venta);
       }
   }

   @Override
    public void crearVenta(Venta venta){

       this.repositoryVenta.save(venta);
   }

   @Override
    public void eliminarVenta(int id){
       Venta venta=this.repositoryVenta.encontrarporId(id);
       if (venta!=null){
           this.repositoryVenta.delete(venta);
       }

   }
}
