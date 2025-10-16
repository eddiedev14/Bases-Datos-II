package com.apirest.backend.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.apirest.backend.DTO.EmpleadoCreateDTO;
import com.apirest.backend.DTO.EmpleadoEquiposDTO;
import com.apirest.backend.DTO.EmpleadoResponseDTO;
import com.apirest.backend.Model.EmpleadosModel;

public interface IEmpleadosService {
    public EmpleadoResponseDTO guardarEmpleado(EmpleadoCreateDTO empleado);
    public List<EmpleadoResponseDTO> listarEmpleados();
    public EmpleadosModel buscarEmpleadosPorId(ObjectId id);
    /* 
    public EmpleadosModel actualizarEmpleado(ObjectId id, EmpleadosModel empleado);
    public String eliminarEmpleado(ObjectId id);*/
    List<EmpleadoEquiposDTO> equiposAsignadosPorEmpleado(ObjectId empleadoId);
}
