package com.alkeamy.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "pelicula")
public class PeliculaEntity {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Long id;

	    private String imagen;

	    private String titulo;

	    @Column(name = "fecha_creacion")
	    @DateTimeFormat(pattern = "yyyy/MM/dd")
	    private LocalDate fechaCreacion;

	    private int calificacion;

	    private boolean deleted = Boolean.FALSE;



	    @ManyToMany(
	            cascade = {
	                    CascadeType.PERSIST,
	                    CascadeType.MERGE
	            },
	            fetch = FetchType.LAZY
	    )@JoinTable(
	            name = "pelicula_personaje",
	            joinColumns = @JoinColumn(name = "pelicula_id"),
	            inverseJoinColumns = @JoinColumn(name = "personaje_id")

	    )
	    private List<PersonajeEntity> personajes = new ArrayList<PersonajeEntity>();

	    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    private GeneroEntity genero;

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

		public LocalDate getFechaCreacion() {
			return fechaCreacion;
		}

		public void setFechaCreacion(LocalDate fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}

		public int getCalificacion() {
			return calificacion;
		}

		public void setCalificacion(int calificacion) {
			this.calificacion = calificacion;
		}

		public boolean isDeleted() {
			return deleted;
		}

		public void setDeleted(boolean deleted) {
			this.deleted = deleted;
		}

		public List<PersonajeEntity> getPersonajes() {
			return personajes;
		}

		public void setPersonajes(List<PersonajeEntity> personajes) {
			this.personajes = personajes;
		}

		public GeneroEntity getGenero() {
			return genero;
		}

		public void setGenero(GeneroEntity genero) {
			this.genero = genero;
		}
	    
	    

}
