package com.apirest.backend.Repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.apirest.backend.Model.EmpleadosModel;
import com.apirest.backend.DTO.EmpleadoEquiposDTO;

public interface IEmpleadosRepository extends MongoRepository<EmpleadosModel,ObjectId> {
    //* Agregación */
    @Aggregation(pipeline = {
        "{ $match: { _id: ?0 } }", // * ?0 Hace referencial al primer parametro del metodo (empleadoId)
        "{ $lookup: {" +
              "from: 'equipos' ," +
              "let: { empleadoId: '$_id' }," + // Cambiar localField por let
              "pipeline: [" +
                "{ $unwind: '$asignaciones' }," +
                "{ $match: {$expr: { $eq: ['$asignaciones.empleadoId', '$$empleadoId'] } } }," +
                "{ $project: {" +
                  "_id: 0, equipo: '$nombre', serial: 1, fecha: '$asignaciones.fecha', estado: '$asignaciones.estado'" +
                "}}" +
              "]," +																																																																																																																				
              "as: 'equipos_Asignados'" +
            "} }",
        "{ $project: { _id: 0, nombreEmpleado: '$nombre', equiposAsignados: '$equipos_Asignados' } }"
    })

    //* Método para ejecutar la agregación -                   ?0*/
    List<EmpleadoEquiposDTO> equiposAsignadosPorEmpleado(ObjectId empleadoId);
}
