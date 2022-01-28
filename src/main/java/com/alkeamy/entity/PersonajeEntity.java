package com.alkeamy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personaje")
public class PersonajeEntity {
	
	 	@Id
	    @GeneratedValue (strategy = GenerationType.SEQUENCE)
	    private Long id;

	    private boolean deleted = Boolean.FALSE;

	    private String imagen;

	    private String nombre;

	    private int edad;

	    private double peso;

	    private String historia;

	    @ManyToMany(mappedBy = "personajes", cascade = CascadeType.ALL, fetch  = FetchType.LAZY)
	    private List<PeliculaEntity> peliculas = new ArrayList<>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public boolean isDeleted() {
			return deleted;
		}

		public void setDeleted(boolean deleted) {
			this.deleted = deleted;
		}

		public String getImagen() {
			return imagen;
		}

		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public double getPeso() {
			return peso;
		}

		public void setPeso(double peso) {
			this.peso = peso;
		}

		public String getHistoria() {
			return historia;
		}

		public void setHistoria(String historia) {
			this.historia = historia;
		}

		public List<PeliculaEntity> getPeliculas() {
			return peliculas;
		}

		public void setPeliculas(List<PeliculaEntity> peliculas) {
			this.peliculas = peliculas;
		}
	    
	    
}
