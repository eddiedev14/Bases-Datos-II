package com.apirest.backend.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.Model.EquiposModel;
import com.apirest.backend.Service.IEquiposService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping ("/UAO/apirest/equipos")
public class EquiposController {
    @Autowired IEquiposService equiposService;

    @PostMapping("/insertar")
    ResponseEntity<EquiposModel> crearEquipo(@RequestBody EquiposModel equipo){
        return new ResponseEntity<EquiposModel>(equiposService.crearEquipo(equipo),HttpStatus.CREATED);
    }
    @GetMapping("/listar")
    ResponseEntity<List<EquiposModel>> listarEquipos(){
        return new ResponseEntity<List<EquiposModel>>(equiposService.listarEquipos(), HttpStatus.OK);
    }
    @PostMapping("/asignacion/{idequipo}/{idempleado}")
    ResponseEntity<EquiposModel> crearAsignacion(@PathVariable ObjectId idequipo, @PathVariable ObjectId idempleado){
        return new ResponseEntity<EquiposModel>(equiposService.crearAsignacion(idequipo,idempleado), HttpStatus.OK);
    }
}
