package com.lauraprog.demoConcesionario.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class VentaDto {

    public int id;

    public Date Fecha;

    public int Valor;


}
