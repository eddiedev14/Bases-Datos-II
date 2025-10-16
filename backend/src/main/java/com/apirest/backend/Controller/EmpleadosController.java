package com.apirest.backend.Controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.backend.DTO.EmpleadoCreateDTO;
import com.apirest.backend.DTO.EmpleadoEquiposDTO;
import com.apirest.backend.DTO.EmpleadoResponseDTO;
import com.apirest.backend.Model.EmpleadosModel;
import com.apirest.backend.Service.IEmpleadosService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping ("/UAO/apirest/empleados") // endpoint
public class EmpleadosController {
    @Autowired IEmpleadosService empleadosService;
    @PostMapping("/insertar")
    public ResponseEntity<EmpleadoResponseDTO> crearEmpleado(@RequestBody EmpleadoCreateDTO empleado){
        return new ResponseEntity<EmpleadoResponseDTO>(empleadosService.guardarEmpleado(empleado),HttpStatus.CREATED);
    }
    
    @GetMapping("/listar")
    public ResponseEntity<List<EmpleadoResponseDTO>> listarEmpleados(){
        return new ResponseEntity<List<EmpleadoResponseDTO>>(empleadosService.listarEmpleados(),HttpStatus.OK);
    }

    @GetMapping("/empleadoporid/{id}")
    public ResponseEntity<EmpleadosModel> buscarEmpleadosPorId(@PathVariable ObjectId id){
        return new ResponseEntity<EmpleadosModel>(empleadosService.buscarEmpleadosPorId(id),HttpStatus.OK);
    }
    
    @GetMapping("/equiposAsignados/{id}")
    public ResponseEntity<List<EmpleadoEquiposDTO>> equiposAsignadosPorEmpleado(@PathVariable ObjectId id) {
        return new ResponseEntity<List<EmpleadoEquiposDTO>>(empleadosService.equiposAsignadosPorEmpleado(id), HttpStatus.OK);
    }
    
}
