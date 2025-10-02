package com.apirest.backend.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.Model.AsignacionesEmpleados;
import com.apirest.backend.Model.EmpleadosModel;
import com.apirest.backend.Model.EquiposModel;
import com.apirest.backend.Service.IEmpleadoService;
import com.apirest.backend.Service.IEquipoService;

@RestController
@RequestMapping ("/UAO/apirest/equipos") //Dirección del endpoint
public class EquiposController {
    //Inyección de dependencias de la interface porque se comunica con el servicio
    @Autowired IEquipoService equipoService;

    //Creando método POST
    @PostMapping("/insertar") //Path despues del prefix de RequestMapping
    public ResponseEntity<EquiposModel> crearEquipo(@RequestBody EquiposModel equipo){ //Se le pasa a ResponseEntity lo que devolverá como respuesta y al metodo lo que le llega como request
        return new ResponseEntity<EquiposModel>(equipoService.crearEquipo(equipo), HttpStatus.CREATED);
    }

    //Crear asignación
    @PostMapping("/asignacion/{idequipo}/{idempleado}") //Path despues del prefix de RequestMapping
    public ResponseEntity<EquiposModel> crearAsignacion(@PathVariable ObjectId idequipo, @PathVariable ObjectId idempleado){ //Se le pasa a ResponseEntity lo que devolverá como respuesta y al metodo lo que le llega como request
        return new ResponseEntity<EquiposModel>(equipoService.crearAsignacion(idequipo, idempleado), HttpStatus.CREATED);
    }

    // Método GET
     @GetMapping("/listar")
     public ResponseEntity<List<EquiposModel>> listarEquipos(){
        return new ResponseEntity<List<EquiposModel>>(equipoService.listarEquipos(), HttpStatus.OK);
     }
}
