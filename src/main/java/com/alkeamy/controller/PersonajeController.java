package com.alkeamy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkeamy.dto.PersonajeBasicDTO;
import com.alkeamy.dto.PersonajeDTO;
import com.alkeamy.service.PersonajeService;

@RestController
@RequestMapping("personajes")
public class PersonajeController {

	private PersonajeService personajeService;

	public PersonajeController(@Autowired @Lazy PersonajeService personajeService) {
		this.personajeService = personajeService;
	}

	@GetMapping("/characters")
	public ResponseEntity<List<PersonajeBasicDTO>> getAllBasic() {

		List<PersonajeBasicDTO> personajesBasicos = personajeService.getAllBasics();

		return ResponseEntity.status(HttpStatus.OK).body(personajesBasicos);
	}

	@PostMapping
	public ResponseEntity<PersonajeDTO> save(@RequestBody PersonajeDTO personaje) {

		PersonajeDTO personajeGuardado = personajeService.save(personaje);

		return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
	}

	@GetMapping
	public ResponseEntity<List<PersonajeDTO>> getAll() {

		List<PersonajeDTO> personaje = personajeService.getAllPersonajes();

		return ResponseEntity.status(HttpStatus.OK).body(personaje);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PersonajeDTO> detallesDePersonaje(@PathVariable Long id) {

		PersonajeDTO personajeDTO = personajeService.getDetalles(id);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(personajeDTO);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.personajeService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<PersonajeDTO> put(@PathVariable Long id, @RequestBody PersonajeDTO edit) {
		PersonajeDTO putPersonaje = personajeService.putPersonaje(id, edit);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(putPersonaje);
	}

}
