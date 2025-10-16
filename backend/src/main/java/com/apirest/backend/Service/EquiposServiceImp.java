package com.apirest.backend.Service;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Exception.RecursoNoEncontradoException;
import com.apirest.backend.Model.AsignacionesEmpleado;
import com.apirest.backend.Model.EmpleadosModel;
import com.apirest.backend.Model.EquiposModel;
import com.apirest.backend.Model.EstadoEquipo;
import com.apirest.backend.Repository.IEquiposRepository;
@Service
public class EquiposServiceImp implements IEquiposService{
    @Autowired IEquiposRepository equiposRepository;
    @Autowired IEmpleadosService empleadosService;
    @Override
    public EquiposModel crearEquipo(EquiposModel equipo) {
        return equiposRepository.save(equipo);
    }

    @Override
    public List<EquiposModel> listarEquipos() {
        return equiposRepository.findAll();
    }

    @Override
    public EquiposModel buscarEquipoPorId(ObjectId idEquipo) {
        return equiposRepository.findById(idEquipo).
        orElseThrow(()-> new RecursoNoEncontradoException("Error! El equipo con el ID "+idEquipo+", no existe."));
    }

    @Override
    public EquiposModel crearAsignacion(ObjectId idEquipo, ObjectId idEmpleado) {
       //buscar el equipo
       EquiposModel equipoExistente = buscarEquipoPorId(idEquipo);
       EmpleadosModel empleadoExistente = empleadosService.buscarEmpleadosPorId(idEmpleado);
       AsignacionesEmpleado asignacion = new AsignacionesEmpleado();
       asignacion.setEmpleadoId(empleadoExistente.getId());
       asignacion.setNombreEmpleado(empleadoExistente.getNombre());
       asignacion.setFecha(LocalDate.now());
       asignacion.setEstado(EstadoEquipo.asignado);
       equipoExistente.crearAsignacion(asignacion);
       return equiposRepository.save(equipoExistente);
    }
    
}
