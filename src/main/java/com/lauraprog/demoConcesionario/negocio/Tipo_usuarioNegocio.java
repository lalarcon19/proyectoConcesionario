package com.lauraprog.demoConcesionario.negocio;

import com.lauraprog.demoConcesionario.dto.Tipo_usuarioDto;
import com.lauraprog.demoConcesionario.entity.Tipo_usuario;
import com.lauraprog.demoConcesionario.implementacion.Tipo_usuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Tipo_usuarioNegocio {


    @Autowired
    private Tipo_usuarioImpl tipo_usuarioImpl;
    private List<Tipo_usuarioDto> listDtoTipo_usuarios;

    public List<Tipo_usuarioDto> encontrarTodos(){
        listDtoTipo_usuarios = new ArrayList<>();
        this.tipo_usuarioImpl.encontrarTodos().forEach(tipo_Usuario -> {

            Tipo_usuarioDto tipo_usuarioDto = new Tipo_usuarioDto();
            tipo_usuarioDto.setId(tipo_Usuario.getId());
            tipo_usuarioDto.setCliente(tipo_Usuario.getCliente());
            tipo_usuarioDto.setEmpleado(tipo_Usuario.getEmpleado());
            this.listDtoTipo_usuarios.add(tipo_usuarioDto);

        });
        return this.listDtoTipo_usuarios;
    }

    public String guardarTipo_usuario(Tipo_usuarioDto tipo_usuarioDto) {
        Tipo_usuario tipo_usuario = new Tipo_usuario();
        try {if (tipo_usuarioDto.getId() != 0) {
                tipo_usuario.setId(tipo_usuarioDto.getId());
                tipo_usuario.setCliente(tipo_usuarioDto.getCliente());
                tipo_usuario.setEmpleado(tipo_usuarioDto.getEmpleado());
                this.tipo_usuarioImpl.actualizarTipo_usuario(tipo_usuario);

            } else {
                tipo_usuario.setCliente(tipo_usuarioDto.getCliente());
                tipo_usuario.setEmpleado(tipo_usuarioDto.getEmpleado());
                this.tipo_usuarioImpl.crearTipo_usuario(tipo_usuario);
            }
            return "Los datos se guardaron";

        } catch (Exception e) {
            return "Fallo algo";
        }
    }


}
