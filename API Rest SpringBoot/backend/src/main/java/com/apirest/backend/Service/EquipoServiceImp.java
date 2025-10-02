package com.apirest.backend.Service;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Exception.RecursoNoEncontradoException;
import com.apirest.backend.Model.AsignacionesEmpleados;
import com.apirest.backend.Model.EmpleadosModel;
import com.apirest.backend.Model.EquiposModel;
import com.apirest.backend.Model.EstadoEquipo;
import com.apirest.backend.Repository.IEquiposRepository;

@Service
public class EquipoServiceImp implements IEquipoService {
    @Autowired IEquiposRepository equiposRepository;
    @Autowired IEmpleadoService empleadoService;

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
        // Obtener equipo por ID (Incluye excepcion)
        return equiposRepository.findById(idEquipo).
        orElseThrow(() -> new RecursoNoEncontradoException("Error! No existe un equipo con el id: " + idEquipo + "o está mal escrito"));
    }

    @Override
    public EquiposModel crearAsignacion(ObjectId idEquipo, ObjectId idEmpleado) {
        // Buscar el equipo
        EquiposModel equipoExistente = buscarEquipoPorId(idEquipo);

        // Validar si el empleado existe
        EmpleadosModel empleadoExistente = empleadoService.buscarEmpleadoPorId(idEmpleado);

        // Asignar campos desnormalizados de la asignacion
        AsignacionesEmpleados asignacion = new AsignacionesEmpleados();
        asignacion.setEmpleadoId(idEmpleado);
        asignacion.setNombreEmpleado(empleadoExistente.getNombre());
        asignacion.setFecha(LocalDate.now());
        asignacion.setEstado(EstadoEquipo.asignado);

        // Agregar asignacion al array de asignaciones del equipo
        equipoExistente.crearAsignacion(asignacion);
        return equiposRepository.save(equipoExistente);
    }
}
