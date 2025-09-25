package com.apirest.backend.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.apirest.backend.Model.EmpleadosModel;

public interface IEmpleadosRepository extends MongoRepository<EmpleadosModel, ObjectId> {
    //* Aquí se programan las agregaciones necesarias */
}
