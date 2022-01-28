package com.alkeamy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkeamy.entity.PersonajeEntity;
@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {

}
