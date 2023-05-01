package com.lauraprog.demoConcesionario.negocio;

import com.lauraprog.demoConcesionario.dto.ConcesionarioDto;
import com.lauraprog.demoConcesionario.entity.Concesionario;
import com.lauraprog.demoConcesionario.implementacion.ConcesionarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConcesionarioNegocio {

    @Autowired
    private ConcesionarioImpl concesionarioimpl;

    private List<ConcesionarioDto> listDtoConcesionarios;

    public  List<ConcesionarioDto> encontrarTodos(){
        listDtoConcesionarios=new  ArrayList<>();
        this.concesionarioimpl.encontrarTodos().forEach(concesionario -> {
            ConcesionarioDto concesionarioDto=new ConcesionarioDto();

            concesionarioDto.setId(concesionario.getId());
            concesionarioDto.setNombre(concesionario.getNombre());
            concesionarioDto.setDireccion(concesionario.getDireccion());
            concesionarioDto.setSede(concesionario.getSede());
            this.listDtoConcesionarios.add(concesionarioDto);
        });
        return this.listDtoConcesionarios;
    }

    public  String guardarConcesionario (ConcesionarioDto concesionarioDto){
        Concesionario concesionario=new Concesionario();
        try { if (concesionarioDto.getId() !=0){
         concesionario.setId(concesionarioDto.getId());
         concesionario.setNombre(concesionarioDto.getNombre());
         concesionario.setDireccion(concesionarioDto.getDireccion());
         concesionario.setSede(concesionarioDto.getSede());
         this.concesionarioimpl.actualizarConcesionario(concesionario);
        } else {
            concesionario.setNombre(concesionarioDto.getNombre());
            concesionario.setDireccion(concesionarioDto.getDireccion());
            concesionario.setSede(concesionarioDto.getSede());
            this.concesionarioimpl.crearConcesionario(concesionario);
        }
            return "Los datos se guardaron";

        } catch (Exception e){
            return "Algo fallo";
        }

    }

}
