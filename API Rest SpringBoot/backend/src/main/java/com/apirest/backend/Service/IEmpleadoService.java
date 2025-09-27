package com.apirest.backend.Service;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;

import com.apirest.backend.Model.EmpleadosModel;

public interface IEmpleadoService {
    public abstract EmpleadosModel guardarEmpleado(EmpleadosModel empleado);
    public abstract List<EmpleadosModel> listarEmpleados();
    public abstract EmpleadosModel buscarEmpleadoPorId(ObjectId id);
    public abstract EmpleadosModel actualizarEmpleadoCompleto(ObjectId id, EmpleadosModel empleado);
    public abstract EmpleadosModel actualizarEmpleadoParcial(ObjectId id, Map<String, Object> campos);
    public abstract String eliminarEmpleado(ObjectId id);
}
