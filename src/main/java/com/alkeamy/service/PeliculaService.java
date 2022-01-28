package com.alkeamy.service;

import java.util.List;

import com.alkeamy.dto.PeliculaBasicDTO;
import com.alkeamy.dto.PeliculaDTO;

public interface PeliculaService {

	PeliculaDTO save(PeliculaDTO pelicula);

    List<PeliculaDTO> getAllPelicula();

    void delete(Long id);

    PeliculaDTO putPelicula(Long id, PeliculaDTO edit);

    List<PeliculaBasicDTO> getAllBasics();
}
