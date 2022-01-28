package com.alkeamy.service;

import java.util.List;

import com.alkeamy.dto.PersonajeBasicDTO;
import com.alkeamy.dto.PersonajeDTO;

public interface PersonajeService {

	PersonajeDTO save(PersonajeDTO dto);

    List<PersonajeDTO> getAllPersonajes();

    void delete(Long id);

    PersonajeDTO putPersonaje(Long id, PersonajeDTO edit);

    List<PersonajeBasicDTO> getAllBasics();

    PersonajeDTO getDetalles(Long id);
}
