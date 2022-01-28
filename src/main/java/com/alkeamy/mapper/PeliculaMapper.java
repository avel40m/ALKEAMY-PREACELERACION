package com.alkeamy.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.alkeamy.dto.PeliculaBasicDTO;
import com.alkeamy.dto.PeliculaDTO;
import com.alkeamy.entity.GeneroEntity;
import com.alkeamy.entity.PeliculaEntity;

@Component
public class PeliculaMapper {

	   private PersonajeMapper personajeMapper;

	    public PeliculaMapper(@Autowired @Lazy PersonajeMapper personajeMapper) {
	        this.personajeMapper = personajeMapper;
	    }

	    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto, GeneroEntity generoEntity) {

	        PeliculaEntity peliculaEntity = new PeliculaEntity();


	        peliculaEntity.setTitulo(dto.getTitulo());
	        peliculaEntity.setFechaCreacion(this.String2LocalDate(dto.getFechaCreacion()));
	        peliculaEntity.setImagen(dto.getImagen());
	        peliculaEntity.setCalificacion(dto.getCalificacion());
	        peliculaEntity.setPersonajes(personajeMapper.perosonajeEntityList(dto.getPeliculaPersonaje()));
	        peliculaEntity.setGenero(generoEntity);


	        return peliculaEntity;
	    }


	    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity, boolean mostrarPersonajes){

	        PeliculaDTO dto = new PeliculaDTO();

	        dto.setId(entity.getId());
	        dto.setTitulo(entity.getTitulo());
	        dto.setFechaCreacion(entity.getFechaCreacion().toString());
	        dto.setImagen(entity.getImagen());
	        dto.setCalificacion(entity.getCalificacion());
	        dto.setPeliculaPersonaje(personajeMapper.personajeEntityList2DTOList(entity.getPersonajes(), false));

	       /* if (mostrarPersonajes){
	            List<PersonajeDTO> personajeDTOS = this.personajeMapper.personajeEntityList2DTOList(entity.getPersonajes(),false);
	            dto.setPeliculaPersonaje(personajeDTOS);
	             //dto.setPeliculaPersonaje(personajeMapper.personajeEntityList2DTOList(entity.getPersonajes(),false));
	        }*/

	        return dto;
	    }
	    public List<PeliculaDTO> peliculaEntityList2DtoList(List<PeliculaEntity> listaEntity, boolean b){
	        List<PeliculaDTO>dtoLista = new ArrayList<>();
	        for(PeliculaEntity ent : listaEntity){
	            dtoLista.add(this.peliculaEntity2DTO(ent, b));
	        }
	        return dtoLista;
	    }



	    public LocalDate String2LocalDate(String stringDate) {
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(stringDate, formato);
	        return date;
	    }


	    public List<PeliculaBasicDTO> peliculaBasicEntityList2DtoList(List<PeliculaEntity> peliculaEntities) {

	        List<PeliculaBasicDTO>dtoLista = new ArrayList<>();
	        for(PeliculaEntity aux : peliculaEntities){
	            dtoLista.add(this.peliculaBasicEntity2Dto(aux));
	        }
	        return dtoLista;


	    }

	    private PeliculaBasicDTO peliculaBasicEntity2Dto(PeliculaEntity aux) {

	        PeliculaBasicDTO peliculaBasicDTO = new PeliculaBasicDTO();

	        peliculaBasicDTO.setImagen(aux.getImagen());
	        peliculaBasicDTO.setTitulo(aux.getTitulo());
	        peliculaBasicDTO.setFechaCreacion(aux.getFechaCreacion().toString());

	        return peliculaBasicDTO;
	    }

}
