package com.alkeamy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.alkeamy.service.GeneroService;
import com.alkeamy.repository.GeneroRepository;
import com.alkeamy.dto.GeneroDTO;
import com.alkeamy.entity.GeneroEntity;
import com.alkeamy.mapper.GeneroMapper;

@Service
public class GeneroServiceImpl implements GeneroService {
	
	 private GeneroMapper generoMapper;

	    private GeneroRepository generoRepository;

	    public GeneroServiceImpl(@Autowired @Lazy GeneroMapper generoMapper, GeneroRepository generoRepository) {
	        this.generoMapper = generoMapper;
	        this.generoRepository = generoRepository;
	    }

	    @Override
	    public GeneroDTO save(GeneroDTO genero) {

	        GeneroEntity generoEntity = generoMapper.generoDTO2Entity(genero);
	        GeneroEntity generoSaved = generoRepository.save(generoEntity);
	        GeneroDTO resultado = generoMapper.generoEntity2DTO(generoSaved);

	        return resultado;
	    }
}
