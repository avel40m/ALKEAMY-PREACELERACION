package com.alkeamy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkeamy.entity.PeliculaEntity;
@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {

}
