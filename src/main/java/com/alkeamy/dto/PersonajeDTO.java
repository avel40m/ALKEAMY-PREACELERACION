package com.alkeamy.dto;

import java.util.List;

public class PersonajeDTO {
    private Long id;
    private String imagen;
    private String nombre;
    private int edad;
    private double peso;
    private String historia;
    private List<PeliculaDTO> personajePelicula;
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
	public List<PeliculaDTO> getPersonajePelicula() {
		return personajePelicula;
	}
	public void setPersonajePelicula(List<PeliculaDTO> personajePelicula) {
		this.personajePelicula = personajePelicula;
	}
    
    
}
