package com.apirest.backend.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.apirest.backend.DTO.EmpleadoEquiposDTO;
import com.apirest.backend.Model.EmpleadosModel;

public interface IEmpleadosService {
    public EmpleadosModel guardarEmpleado(EmpleadosModel empleado);
    public List<EmpleadosModel> listarEmpleados();
    public EmpleadosModel buscarEmpleadosPorId(ObjectId id);
    /* 
    public EmpleadosModel actualizarEmpleado(ObjectId id, EmpleadosModel empleado);
    public String eliminarEmpleado(ObjectId id);*/
    List<EmpleadoEquiposDTO> equiposAsignadosPorEmpleado(ObjectId empleadoId);
}
