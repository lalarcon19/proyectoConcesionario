package com.lauraprog.demoConcesionario.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ventas")
@Data
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name= " fecha")
    private Date Fecha;

    @Column(name="valor")
    private int Valor;

    @ManyToOne
    @JoinColumn(name = "Usuario_id")
    private Usuario fk_idVenta;

    @JsonIgnore
    @OneToMany(mappedBy = "fk_idVehiculo")
    private List<Vehiculo> Listvehiculos;





}
