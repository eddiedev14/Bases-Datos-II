package com.apirest.backend.Service;

import java.util.List;

import org.bson.types.ObjectId;


import com.apirest.backend.Model.EquiposModel;

public interface IEquiposService {
    EquiposModel crearEquipo(EquiposModel equipo);
    List<EquiposModel> listarEquipos();
    EquiposModel buscarEquipoPorId(ObjectId idEquipo);
    EquiposModel crearAsignacion(ObjectId idEquipo, ObjectId idEmpleado);
}
