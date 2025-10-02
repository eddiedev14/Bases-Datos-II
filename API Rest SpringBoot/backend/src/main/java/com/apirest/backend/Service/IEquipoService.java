package com.apirest.backend.Service;

import java.util.List;

import org.bson.types.ObjectId;

import com.apirest.backend.Model.AsignacionesEmpleados;
import com.apirest.backend.Model.EquiposModel;

public interface IEquipoService {
    public abstract EquiposModel crearEquipo(EquiposModel equipo);
    public abstract List<EquiposModel> listarEquipos();
    public abstract EquiposModel buscarEquipoPorId(ObjectId idEquipo);
    public abstract EquiposModel crearAsignacion(ObjectId idEquipo, ObjectId idEmpleado);
}
