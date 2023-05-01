package com.lauraprog.demoConcesionario.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConcesionarioDto {

    private int Id;

    private String Nombre;

    private String Direccion;

    private String Sede;

}
