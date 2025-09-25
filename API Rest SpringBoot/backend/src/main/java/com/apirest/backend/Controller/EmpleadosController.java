package com.apirest.backend.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.Model.EmpleadosModel;
import com.apirest.backend.Service.IEmpleadoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping ("/UAO/apirest/empleados") //Dirección del endpoint
public class EmpleadosController {
    //Inyección de dependencias de la interface porque se comunica con el servicio
    @Autowired IEmpleadoService empleadoService;

    //Creando método POST
    @PostMapping("/insertar") //Path despues del prefix de RequestMapping
    public ResponseEntity<EmpleadosModel> crearEmpleado(@RequestBody EmpleadosModel empleado){ //Se le pasa a ResponseEntity lo que devolverá como respuesta y al metodo lo que le llega como request
        return new ResponseEntity<EmpleadosModel>(empleadoService.guardarEmpleado(empleado), HttpStatus.CREATED);
    }
    
    // Método GET
     @GetMapping("/listar")
     public ResponseEntity<List<EmpleadosModel>> listarEmpleados(){
        return new ResponseEntity<List<EmpleadosModel>>(empleadoService.listarEmpleados(), HttpStatus.OK);
     }

     @GetMapping("/empleadoporid/{id}")
     public ResponseEntity<EmpleadosModel> buscarEmpleadosPorId(@PathVariable ObjectId id){
        return new ResponseEntity<EmpleadosModel>(empleadoService.buscarEmpleadoPorId(id), HttpStatus.OK);
     }
     
     
}
