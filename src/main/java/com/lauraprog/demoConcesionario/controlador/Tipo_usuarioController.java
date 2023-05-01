package com.lauraprog.demoConcesionario.controlador;

import com.lauraprog.demoConcesionario.dto.Tipo_usuarioDto;

import com.lauraprog.demoConcesionario.negocio.Tipo_usuarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/tipo_usuario")
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class Tipo_usuarioController {
    @Autowired
   private Tipo_usuarioNegocio tipo_usuarioNegocio;

    @Autowired
    Tipo_usuarioDto tipo_usuarioDto;


    @GetMapping( "/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){
        Map<String,Object> res=new HashMap<>();

        List<Tipo_usuarioDto> listDto=this.tipo_usuarioNegocio.encontrarTodos();
        res.put("status","ok");
        res.put("data",listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearTipo_Usuario(@RequestBody  Map<String,Object>request){
        Map<String,Object> res=new HashMap<String,Object>();

        System.out.println("@@"+request.toString());
        Tipo_usuarioDto tipo_usuarioDto=new Tipo_usuarioDto();

        tipo_usuarioDto.setId(0);
        tipo_usuarioDto.setCliente(request.get("cliente").toString());
        tipo_usuarioDto.setEmpleado(request.get("empleado").toString());
        String respuesta=this.tipo_usuarioNegocio.guardarTipo_usuario(tipo_usuarioDto);

        res.put("status","ok");
        res.put("data",respuesta);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping ("/update")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> actualizarTipo_usuario(@RequestBody  Map<String,Object>request){
        Map<String, Object> res = new HashMap<>();

        System.out.println("@@"+request.toString());
        Tipo_usuarioDto tipo_usuarioDto=new Tipo_usuarioDto();

        tipo_usuarioDto.setId(Integer.parseInt(request.get("id").toString()));
        tipo_usuarioDto.setCliente(request.get("cliente").toString());
        tipo_usuarioDto.setEmpleado(request.get("empleado").toString());
        String respuesta = this.tipo_usuarioNegocio.guardarTipo_usuario(tipo_usuarioDto);

        res.put("status","ok");
        res.put("data", respuesta);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
