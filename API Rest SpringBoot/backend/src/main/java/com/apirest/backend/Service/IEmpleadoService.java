package com.apirest.backend.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.apirest.backend.Model.EmpleadosModel;

public interface IEmpleadoService {
    public abstract EmpleadosModel guardarEmpleado(EmpleadosModel empleado);
    public abstract List<EmpleadosModel> listarEmpleados();
    public abstract EmpleadosModel buscarEmpleadoPorId(ObjectId id);
    public abstract EmpleadosModel actualizarEmpleado(ObjectId id, EmpleadosModel empleado);
    public abstract String eliminarEmpleado(ObjectId id);
}
