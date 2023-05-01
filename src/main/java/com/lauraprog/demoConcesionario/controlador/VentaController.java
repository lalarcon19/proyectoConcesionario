package com.lauraprog.demoConcesionario.controlador;

import com.lauraprog.demoConcesionario.dto.VentaDto;
import com.lauraprog.demoConcesionario.entity.Venta;
import com.lauraprog.demoConcesionario.implementacion.VentaImpl;
import com.lauraprog.demoConcesionario.negocio.VentaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/venta")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class VentaController {
    @Autowired
    public VentaNegocio ventaNegocio;

    @Autowired
    public VentaDto ventaDto;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){
        Map<String,Object> res= new HashMap<>();
        List<VentaDto> listDto=this.ventaNegocio.encontrarTodos();
        res.put("status","ok");
        res.put("data",listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearVenta(@RequestBody Map<String,Object>request){
        Map<String,Object> res=new HashMap<String,Object>();

        System.out.println("@@@"+request.toString());
        VentaDto ventaDto = new VentaDto();

        ventaDto.setId(0);
        ventaDto.setFecha(new Date());
        ventaDto.setValor(Integer.parseInt(request.get("Valor").toString()));
        String respuesta=this.ventaNegocio.guardarVenta(ventaDto);

        res.put("status","ok");
        res.put("data",respuesta);
        return new ResponseEntity<>(res,HttpStatus.OK);

    }
    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String,Object>>actualizarVenta(@RequestBody Map<String,Object>request){
        Map<String,Object> res=new HashMap<>();

        System.out.println("@@@"+request.toString());
        VentaDto ventaDto=new VentaDto();
        ventaDto.setId(Integer.parseInt(request.get("id").toString()));
        ventaDto.setFecha(new Date());
        ventaDto.setValor(Integer.parseInt(request.get("valor").toString()));
        String respuesta = this.ventaNegocio.guardarVenta(ventaDto);

        res.put("status","ok");
        res.put("data",respuesta);
        return new ResponseEntity<>(res,HttpStatus.OK);
    }
}

