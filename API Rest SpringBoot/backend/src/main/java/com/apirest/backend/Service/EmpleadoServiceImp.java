package com.apirest.backend.Service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.backend.Exception.RecursoNoEncontradoException;
import com.apirest.backend.Model.EmpleadosModel;
import com.apirest.backend.Repository.IEmpleadosRepository;

@Service
public class EmpleadoServiceImp implements IEmpleadoService {
    @Autowired IEmpleadosRepository empleadosRepository;

    @Override
    public EmpleadosModel guardarEmpleado(EmpleadosModel empleado) {
        //Guardar documento en BD
        return empleadosRepository.save(empleado);
    }

    @Override
    public List<EmpleadosModel> listarEmpleados() {
        //Listar documentos de BD
        return empleadosRepository.findAll();
    }

    @Override
    public EmpleadosModel buscarEmpleadoPorId(ObjectId id) {
        // Obtener empleado por ID (Incluye excepcion)
        return empleadosRepository.findById(id).
        orElseThrow(() -> new RecursoNoEncontradoException("Error! No existe un empleado con el id: " + id + "o está mal escrito"));
    }

    @Override
    public EmpleadosModel actualizarEmpleado(ObjectId id, EmpleadosModel empleado) {
        //Actualizar empleado
        return empleadosRepository.save(empleado);
    }

    @Override
    public String eliminarEmpleado(ObjectId id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarEmpleado'");
    }
    
}
