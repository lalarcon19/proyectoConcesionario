package com.lauraprog.demoConcesionario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "concesionarios")
@Data
public class Concesionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre", length = 50)
    private String Nombre;

    @Column(name="direccion",length = 50)
    private String Direccion;

    @Column(name="sede",length = 50)
    private String Sede;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idConcesionario")
    private List<Vehiculo> Listvehiculos;



}
