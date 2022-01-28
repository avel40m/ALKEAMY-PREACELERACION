package com.alkeamy.dto;

import java.util.List;

import javax.persistence.Column;

public class PeliculaDTO {
    private Long id;

    private String imagen;

    private String titulo;

    private String fechaCreacion;

    private int calificacion;

    private List<PersonajeDTO> peliculaPersonaje;

    @Column(name = "genero_id")
    private Long generoId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public List<PersonajeDTO> getPeliculaPersonaje() {
		return peliculaPersonaje;
	}

	public void setPeliculaPersonaje(List<PersonajeDTO> peliculaPersonaje) {
		this.peliculaPersonaje = peliculaPersonaje;
	}

	public Long getGeneroId() {
		return generoId;
	}

	public void setGeneroId(Long generoId) {
		this.generoId = generoId;
	}
    
}
