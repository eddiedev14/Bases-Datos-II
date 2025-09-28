package com.apirest.backend.Service;

import java.util.List;
import java.util.Map;

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
    public EmpleadosModel actualizarEmpleadoCompleto(ObjectId id, EmpleadosModel empleado) {
        //*Actualizar empleado

        //Obtener empleado por ID
        EmpleadosModel empleadoExistente = empleadosRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Error! No existe un empleado con el id: " + id + "o está mal escrito"));

        //Actualizar campos
        empleado.setId(id); //Definimos el mismo ID
        return empleadosRepository.save(empleado); //Se actualiza el objeto
    }

    @Override
    public EmpleadosModel actualizarEmpleadoParcial(ObjectId id, Map<String, Object> datos) {
        //*Actualizar empleado parcial (SOLO ALGUNOS CAMPOS)

        //Obtener empleado por ID
        EmpleadosModel empleado = empleadosRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Error! No existe un empleado con el id: " + id + "o está mal escrito"));

        //Actualizar solo los campos enviados en el Map con los setters, se usa Map.Entry para poder usar notacion JSON
        for (Map.Entry<String, Object> dato : datos.entrySet()) {
            String campo = dato.getKey();
            Object valor = dato.getValue();

            //Se implementa un switch
            switch (campo) {
                case "nombre" -> empleado.setNombre(valor.toString());
                case "edad" -> empleado.setEdad((Integer) valor);
                case "direccion" -> { //* Actualizar documento embebido */
                    Map<String,Object> dirMap = (Map<String,Object>) valor;

                    if (dirMap.containsKey("barrio")) empleado.getDireccion().setBarrio(dirMap.get("barrio").toString());
                    if (dirMap.containsKey("ubicacion")) empleado.getDireccion().setUbicacion(dirMap.get("ubicacion").toString());
                    if (dirMap.containsKey("codPostal")) empleado.getDireccion().setCodPostal((Integer) dirMap.get("codPostal"));
                }
                case "lenguajes" -> empleado.setLenguajes((List<String>) valor); //* Actualizar array de Strings */
                default -> {}
            }
        }

        return empleadosRepository.save(empleado);
    }

    @Override
    public String eliminarEmpleado(ObjectId id) {
        EmpleadosModel empleadoExistente = empleadosRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Error! No existe un empleado con el id: " + id + "o está mal escrito"));
        empleadosRepository.deleteById(id);
        return "El empleado con la id " + id + ", fue eliminado correctamente";
    }
    
}
