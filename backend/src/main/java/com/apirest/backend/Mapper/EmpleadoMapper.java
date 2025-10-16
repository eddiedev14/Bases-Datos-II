package com.apirest.backend.Mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.apirest.backend.DTO.DireccionDTO;
import com.apirest.backend.DTO.EmpleadoCreateDTO;
import com.apirest.backend.DTO.EmpleadoResponseDTO;
import com.apirest.backend.Model.DireccionEmpleado;
import com.apirest.backend.Model.EmpleadosModel;

@Component
public class EmpleadoMapper {

    /**
     * Convierte un EmpleadoCreateDTO a EmpleadosModel
     */
    public EmpleadosModel toModel(EmpleadoCreateDTO dto) {
        EmpleadosModel model = new EmpleadosModel();
        model.setNombre(dto.getNombre());
        model.setEdad(dto.getEdad());
        model.setDireccion(toDireccionModel(dto.getDireccion()));
        model.setLenguajes(dto.getLenguajes());
        return model;
    }

    /**
     * Convierte un EmpleadosModel a EmpleadoResponseDTO
     */
    public EmpleadoResponseDTO toResponseDTO(EmpleadosModel model) {
        EmpleadoResponseDTO dto = new EmpleadoResponseDTO();
        dto.setId(model.getIdAsString());
        dto.setNombre(model.getNombre());
        dto.setEdad(model.getEdad());
        dto.setDireccion(toDireccionDTO(model.getDireccion()));
        dto.setLenguajes(model.getLenguajes());
        return dto;
    }

    /**
     * Convierte una lista de EmpleadosModel a lista de EmpleadoResponseDTO
     */
    public List<EmpleadoResponseDTO> toResponseDTOList(List<EmpleadosModel> models) {
        return models.stream()
                .map(this::toResponseDTO)
                .toList();
    }
    /**
     * Convierte DireccionDTO a DireccionEmpleado
     */
    private DireccionEmpleado toDireccionModel(DireccionDTO dto) {
        if (dto == null) {
            return null;
        }
        DireccionEmpleado model = new DireccionEmpleado();
        model.setUbicacion(dto.getUbicacion());
        model.setBarrio(dto.getBarrio());
        model.setCodPostal(dto.getCodPostal());
        return model;
    }

    /**
     * Convierte DireccionEmpleado a DireccionDTO
     */
    private DireccionDTO toDireccionDTO(DireccionEmpleado model) {
        if (model == null) {
            return null;
        }
        DireccionDTO dto = new DireccionDTO();
        dto.setUbicacion(model.getUbicacion());
        dto.setBarrio(model.getBarrio());
        dto.setCodPostal(model.getCodPostal());
        return dto;
    }
}
