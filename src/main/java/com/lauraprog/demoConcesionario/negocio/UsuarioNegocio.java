package com.lauraprog.demoConcesionario.negocio;

import com.lauraprog.demoConcesionario.dto.UsuarioDto;
import com.lauraprog.demoConcesionario.entity.Usuario;
import com.lauraprog.demoConcesionario.implementacion.UsuarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioNegocio {

    @Autowired
    private UsuarioImpl usuarioImpl;
    private List<UsuarioDto> listDtoUsuarios;

    public List<UsuarioDto> encontrarTodos() {
        listDtoUsuarios=new ArrayList<>();
        this.usuarioImpl.encontrarTodos().forEach(usuario -> {
            UsuarioDto usuarioDto = new UsuarioDto();

            usuarioDto.setId(usuario.getId());
            usuarioDto.setNombre(usuario.getNombre());
            usuarioDto.setApellido(usuario.getApellido());
            usuarioDto.setCorreo(usuario.getCorreo());
            usuarioDto.setDocumento(usuario.getDocumento());
            usuarioDto.setDireccion(usuario.getDireccion());
            usuarioDto.setFechaNac(usuario.getFechaNac());
            usuarioDto.setFechaIngreso(usuario.getFechaIngreso());
            usuarioDto.setEdad(usuario.getEdad());
            usuarioDto.setTelefono(usuario.getTelefono());

            this.listDtoUsuarios.add(usuarioDto);
        });
        return this.listDtoUsuarios;
    }
    public String guardarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario();
        try{ if (usuarioDto.getId() != 0) {
            usuario.setId(usuarioDto.getId());
            usuario.setNombre(usuarioDto.getNombre());
            usuario.setApellido(usuarioDto.getApellido());
            usuario.setCorreo(usuarioDto.getCorreo());
            usuario.setDocumento(usuarioDto.getDocumento());
            usuario.setDireccion(usuarioDto.getDireccion());
            usuario.setFechaNac(usuarioDto.getFechaNac());
            usuario.setFechaIngreso(usuarioDto.getFechaIngreso());
            usuario.setEdad(usuarioDto.getEdad());
            usuario.setTelefono(usuarioDto.getTelefono());
            this.usuarioImpl.actualizarUsuario(usuario);

        } else {
            usuario.setNombre(usuarioDto.getNombre());
            usuario.setApellido(usuarioDto.getApellido());
            usuario.setCorreo(usuarioDto.getCorreo());
            usuario.setDocumento(usuarioDto.getDocumento());
            usuario.setDireccion(usuarioDto.getDireccion());
            usuario.setFechaNac(usuarioDto.getFechaNac());
            usuario.setFechaIngreso(usuarioDto.getFechaIngreso());
            usuario.setEdad(usuarioDto.getEdad());
            usuario.setTelefono(usuarioDto.getTelefono());
            this.usuarioImpl.crearUsuario(usuario);
        }
            return "Los datos se guardaron";

        }catch (Exception e){
            return "Fallo algo";
        }
    }
    }




