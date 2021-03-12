package com.colegio.mapper;

public class NivelMapper {
	
	private Integer nivel_id;
	private String nombre;
	public NivelMapper() {
	}
	
	public NivelMapper(Integer nivel_id) {
		this.nivel_id = nivel_id;
	}

	public NivelMapper(Integer nivel_id, String nombre) {
		this.nivel_id = nivel_id;
		this.nombre = nombre;
	}

	public Integer getNivel_id() {
		return nivel_id;
	}

	public void setNivel_id(Integer nivel_id) {
		this.nivel_id = nivel_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
