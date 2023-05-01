package com.lauraprog.demoConcesionario.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class UsuarioDto {

    private int Id;

    private String Nombre;

    private String Apellido;

    private String Correo;

    private int Documento;

    private String Direccion;

    private Date FechaNac;

    private int Edad;

    private int Telefono;

    private Date FechaIngreso;
}
