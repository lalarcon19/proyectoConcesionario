package com.lauraprog.demoConcesionario.negocio;

import com.lauraprog.demoConcesionario.dto.VehiculoDto;
import com.lauraprog.demoConcesionario.entity.Vehiculo;
import com.lauraprog.demoConcesionario.implementacion.VehiculoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VehiculoNegocio {

    @Autowired
    public VehiculoImpl vehiculoImpl;

    public List<VehiculoDto> listDtoVehiculos;

    public List<VehiculoDto> encontrarTodos() {
        listDtoVehiculos=new ArrayList<>();
        this.vehiculoImpl.encontrarTodos().forEach(vehiculo -> {
            VehiculoDto vehiculoDto =new VehiculoDto();

            vehiculoDto.setId(vehiculo.getId());
            vehiculoDto.setMarca(vehiculo.getMarca());
            vehiculoDto.setModelo(vehiculo.getModelo());
            vehiculoDto.setPlaca(vehiculo.getPlaca());
            vehiculoDto.setPrecio(vehiculo.getPrecio());
            vehiculoDto.setColor(vehiculo.getColor());
            this.listDtoVehiculos.add(vehiculoDto);
        });
        return this.listDtoVehiculos;
    }

    public String guardarVehiculo(VehiculoDto vehiculoDto){
        Vehiculo vehiculo=new Vehiculo();
        try {if (vehiculoDto.getId() !=0){
            vehiculo.setId(vehiculoDto.getId());
            vehiculo.setMarca(vehiculoDto.getMarca());
            vehiculo.setModelo(vehiculoDto.getModelo());
            vehiculo.setPlaca(vehiculoDto.getPlaca());
            vehiculo.setPrecio(vehiculoDto.getPrecio());
            vehiculo.setColor(vehiculoDto.getColor());
            this.vehiculoImpl.actualizarVehiculo(vehiculo);
        }else {
            vehiculo.setMarca(vehiculoDto.getMarca());
            vehiculo.setModelo(vehiculoDto.getModelo());
            vehiculo.setPlaca(vehiculoDto.getPlaca());
            vehiculo.setPrecio(vehiculoDto.getPrecio());
            vehiculo.setColor(vehiculoDto.getColor());
            this.vehiculoImpl.crearVehiculo(vehiculo);
        }
            return "Los datos se han guardado";

        } catch (Exception e){
            return "Fallo algo";
        }
    }


}
