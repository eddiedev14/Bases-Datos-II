package com.apirest.backend.Service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.DTO.EmpleadoCreateDTO;
import com.apirest.backend.DTO.EmpleadoEquiposDTO;
import com.apirest.backend.DTO.EmpleadoResponseDTO;
import com.apirest.backend.Exception.RecursoNoEncontradoException;
import com.apirest.backend.Mapper.EmpleadoMapper;
import com.apirest.backend.Model.EmpleadosModel;
import com.apirest.backend.Repository.IEmpleadosRepository;
@Service

public class EmpleadosServiceImp implements IEmpleadosService {
    @Autowired IEmpleadosRepository empleadosRepository;
    @Autowired EmpleadoMapper empleadoMapper;
    @Override
    public EmpleadoResponseDTO guardarEmpleado(EmpleadoCreateDTO empleado) {
        //* Convertir DTO a Model con el Mapper */
        EmpleadosModel empleadoModel = empleadoMapper.toModel(empleado);

        //* Guardar en la BD */
        empleadosRepository.save(empleadoModel);

        //* Convertir modelo a un DTO */
        return empleadoMapper.toResponseDTO(empleadoModel);
    }

    @Override
    public List<EmpleadosModel> listarEmpleados() {
        return empleadosRepository.findAll();
    }

    @Override
    public EmpleadosModel buscarEmpleadosPorId(ObjectId id) {
          return empleadosRepository.findById(id).
          orElseThrow(()-> new RecursoNoEncontradoException("Error! No existe un empleado con id: "+id+" o está mal escrito."));
    }

    @Override
    public List<EmpleadoEquiposDTO> equiposAsignadosPorEmpleado(ObjectId empleadoId) {
        return empleadosRepository.equiposAsignadosPorEmpleado(empleadoId);
    }
    
}
