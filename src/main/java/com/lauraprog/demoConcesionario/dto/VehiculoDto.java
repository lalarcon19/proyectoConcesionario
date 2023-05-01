package com.lauraprog.demoConcesionario.dto;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class VehiculoDto {

    private int id;


    private String Marca ;


    private String Modelo;


    private String Placa;


    private int Precio;


    private String Color;
}
