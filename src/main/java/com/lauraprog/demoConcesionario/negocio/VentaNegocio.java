package com.lauraprog.demoConcesionario.negocio;

import com.lauraprog.demoConcesionario.dto.VentaDto;
import com.lauraprog.demoConcesionario.entity.Venta;
import com.lauraprog.demoConcesionario.implementacion.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VentaNegocio {

    @Autowired
    private VentaImpl ventaImpl;

    private List<VentaDto> listDtoVentas;

    public List<VentaDto> encontrarTodos(){
        listDtoVentas=new ArrayList<>();
        this.ventaImpl.encontrarTodos().forEach(venta -> {
            VentaDto ventaDto = new VentaDto();

            ventaDto.setId(venta.getId());
            ventaDto.setFecha(venta.getFecha());
            ventaDto.setValor(venta.getValor());
            this.listDtoVentas.add(ventaDto);
        });
        return this.listDtoVentas;

    }
    public String guardarVenta(VentaDto ventaDto){
        Venta venta =new Venta();
        try{if (ventaDto.getId() !=0){
            venta.setId(ventaDto.getId());
            venta.setFecha(ventaDto.getFecha());
            venta.setValor(ventaDto.getValor());
            this.ventaImpl.actualizarVenta(venta);
        }
        return "Los datos se han guardado";

        } catch (Exception e){
            return "Fallo algo";
        }

    }
}
