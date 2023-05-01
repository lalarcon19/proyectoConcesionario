package com.lauraprog.demoConcesionario.entity;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Tipo_usuarios")
@Data
public class Tipo_usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "empleado",length = 11)
    public String empleado;

    @Column(name= "cliente",length = 11)
    public String cliente;

    @ManyToOne
    @JoinColumn(name = "Usuario_id")
    private Usuario fk_idUsuario;


}
