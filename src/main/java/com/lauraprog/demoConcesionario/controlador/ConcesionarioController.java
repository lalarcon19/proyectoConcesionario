package com.lauraprog.demoConcesionario.controlador;

import com.lauraprog.demoConcesionario.dto.ConcesionarioDto;

import com.lauraprog.demoConcesionario.negocio.ConcesionarioNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/concesionario")
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ConcesionarioController {

    @Autowired
    public ConcesionarioNegocio concesionarioNegocio;

    @Autowired
    public ConcesionarioDto concesionarioDto;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> all() {
        Map<String, Object> res = new HashMap<>();
        List<ConcesionarioDto> listDto=this.concesionarioNegocio.encontrarTodos();
        res.put("status","ok");
        res.put("data", listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearConcesionario(@RequestBody Map<String,Object>request){
        Map<String,Object> res = new HashMap<String,Object>();

        System.out.println("@@@@"+request.toString());
        ConcesionarioDto concesionarioDto=new ConcesionarioDto();

        concesionarioDto.setId(0);
        concesionarioDto.setNombre(request.get("nombre").toString());
        concesionarioDto.setDireccion(request.get("direccion").toString());
        concesionarioDto.setSede(request.get("sede").toString());

        String respuesta=this.concesionarioNegocio.guardarConcesionario(concesionarioDto);

        res.put("status","ok");
        res.put("data",respuesta);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String,Object>>actualizarConcesionario(@RequestBody Map<String,Object>request){
        Map<String,Object> res=new HashMap<>();

        System.out.println("@@@@"+request.toString());
        ConcesionarioDto concesionarioDto=new ConcesionarioDto();
        concesionarioDto.setId(Integer.parseInt(request.get("id").toString()));
        concesionarioDto.setNombre(request.get("nombre").toString());
        concesionarioDto.setDireccion(request.get("direccion").toString());
        concesionarioDto.setSede(request.get("sede").toString());
        String respuesta = this.concesionarioNegocio.guardarConcesionario(concesionarioDto);

        res.put("status","ok");
        res.put("data",respuesta);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}