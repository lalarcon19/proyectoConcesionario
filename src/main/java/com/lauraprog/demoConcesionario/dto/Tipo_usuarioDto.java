package com.lauraprog.demoConcesionario.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Tipo_usuarioDto {

    private int id;

    public String empleado;

    public String cliente;

}
