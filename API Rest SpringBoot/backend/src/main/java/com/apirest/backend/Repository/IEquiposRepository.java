package com.apirest.backend.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.apirest.backend.Model.EquiposModel;

public interface IEquiposRepository extends MongoRepository <EquiposModel, ObjectId> {
    //* Query -> Agregación */   
}