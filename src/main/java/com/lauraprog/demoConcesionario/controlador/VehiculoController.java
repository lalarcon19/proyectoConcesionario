package com.lauraprog.demoConcesionario.controlador;

import com.lauraprog.demoConcesionario.dto.VehiculoDto;
import com.lauraprog.demoConcesionario.negocio.VehiculoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/vehiculo")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})


public class VehiculoController {

    @Autowired
    VehiculoNegocio vehiculoNegocio;

    @Autowired
    VehiculoDto vehiculoDto;


    @GetMapping ("/all")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(){
        Map<String,Object> res=new HashMap<>();
        List<VehiculoDto> listDto=this.vehiculoNegocio.encontrarTodos();
        res.put("status","ok");
        res.put("data",listDto);

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> crearVehiculo(@RequestBody  Map<String,Object>request){
        Map<String,Object> res=new HashMap<>();

        System.out.println("@@@@@@"+request.toString());
        VehiculoDto vehiculoDto =new VehiculoDto();

        vehiculoDto.setId(0);
        vehiculoDto.setMarca(request.get("marca").toString());
        vehiculoDto.setModelo(request.get("modelo").toString());
        vehiculoDto.setPlaca(request.get("placa").toString());
        vehiculoDto.setPrecio(Integer.parseInt(request.get("precio").toString()));
        vehiculoDto.setColor(request.get("color").toString());

        String respuesta=this.vehiculoNegocio.guardarVehiculo(vehiculoDto);

        res.put("staus","ok");
        res.put("data",respuesta);
        return  new ResponseEntity<>(res,HttpStatus.OK);

    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<Map<String,Object>>actualizarVehiculo(@RequestBody  Map<String,Object>request){
        Map<String,Object>res =new HashMap<>();

        System.out.println("@@@@@@"+request.toString());
        VehiculoDto vehiculoDto=new VehiculoDto();
        vehiculoDto.setId(Integer.parseInt(request.get("id").toString()));
        vehiculoDto.setMarca(request.get("marca").toString());
        vehiculoDto.setModelo(request.get("modelo").toString());
        vehiculoDto.setPlaca(request.get("placa").toString());
        vehiculoDto.setPrecio(Integer.parseInt(request.get("precio").toString()));
        vehiculoDto.setColor(request.get("precio").toString());
        String respuesta = this.vehiculoNegocio.guardarVehiculo(vehiculoDto);

        res.put("status","ok");
        res.put("data",respuesta);
        return  new ResponseEntity<>(res,HttpStatus.OK);
    }
}
