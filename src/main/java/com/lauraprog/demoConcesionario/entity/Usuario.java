package com.lauraprog.demoConcesionario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "Usuarios")
@Data
public class Usuario implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "nombre",length=25, nullable = false)
   private String Nombre;

    @Column(name = "apellido",length = 25,nullable = false)
    private String Apellido;

    @Column(name ="correo",length = 70)
    private String Correo;

    @Column(name ="documento",nullable = false)
    private int Documento;

    @Column(name = "direccion",length = 25,nullable = false)
    private String Direccion;

    @Temporal(TemporalType.DATE)
    @Column(name ="fechaNac",nullable = false)
    private Date FechaNac;

    @Column(name = "edad",nullable = false)
    private int Edad;

    @Column(name ="telefono")
    private int Telefono;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechaIngreso",nullable = false)
    private Date FechaIngreso;

   @JsonIgnore
    @OneToMany(mappedBy = "fk_idVenta")
    private List<Venta> Listventas;

   @JsonIgnore
    @OneToMany(mappedBy = "fk_idUsuario")
    private List<Tipo_usuario> Listtipo_usuarios;







}
