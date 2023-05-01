package com.lauraprog.demoConcesionario.entity;


import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table (name = "Vehiculos")
@Data

public class Vehiculo implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column (name = "marca",length = 15)
    private String Marca ;

    @Column (name= "modelo",length = 15)
    private String Modelo;

    @Column (name = "placa",length = 15)
    private String Placa;

    @Column (name="precio")
    private int Precio;

    @Column (name= "color",length = 15)
    private String Color;

    @ManyToOne
    @JoinColumn(name="concesionario_id")
    private Concesionario fk_idConcesionario;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private Venta fk_idVehiculo;






}
