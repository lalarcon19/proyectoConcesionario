package com.lauraprog.demoConcesionario.controlador;

import com.lauraprog.demoConcesionario.dto.UsuarioDto;

import com.lauraprog.demoConcesionario.negocio.UsuarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/usuario")
@CrossOrigin(origins="*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class UsuarioController {
    @Autowired
    private UsuarioNegocio usuarioNegocio;

    @Autowired
    private UsuarioDto usuarioDto;

    @GetMapping ("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){
        Map<String,Object> res = new HashMap<>();
        List<UsuarioDto> listDto=this.usuarioNegocio.encontrarTodos();
        res.put("status","ok");
        res.put("data",listDto);

        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String,Object>>crearUsuario(@RequestBody Map<String,Object>request){
        Map<String,Object> res=new HashMap<String,Object>();

        System.out.println("@@@@@@@@"+request.toString());
        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setId(0);
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setDocumento(Integer.parseInt(request.get("documento").toString()));
        usuarioDto.setDireccion(request.get("direccion").toString());
        usuarioDto.setFechaNac(new Date());
        usuarioDto.setEdad(Integer.parseInt(request.get("edad").toString()));
        usuarioDto.setTelefono(request.get("telefono").hashCode());
        usuarioDto.setFechaIngreso(new Date());

        String respuesta=this.usuarioNegocio.guardarUsuario(usuarioDto);

        res.put("status","ok");
        res.put("data",respuesta);
        return new ResponseEntity<>(res,HttpStatus.OK);

    }
    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String,Object>>actualizarUsuario(@RequestBody Map<String,Object>request) {
        Map<String, Object> res = new HashMap<String,Object>();

        System.out.println("@@@@@@"+request.toString());
        UsuarioDto usuarioDto=new UsuarioDto();

        usuarioDto.setId(Integer.parseInt(request.get("id").toString()));
        usuarioDto.setNombre(request.get("nombre").toString());
        usuarioDto.setApellido(request.get("apellido").toString());
        usuarioDto.setCorreo(request.get("correo").toString());
        usuarioDto.setDocumento(Integer.parseInt(request.get("documento").toString()));
        usuarioDto.setDireccion(request.get("direccion").toString());
        usuarioDto.setFechaNac(new Date());
        usuarioDto.setEdad(Integer.parseInt(request.get("edad").toString()));
        usuarioDto.setTelefono(request.get("telefono").hashCode());
        usuarioDto.setFechaIngreso(new Date());
        String respuesta = this.usuarioNegocio.guardarUsuario(usuarioDto);

        res.put("status", "ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }
}




