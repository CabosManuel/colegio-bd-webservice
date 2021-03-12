package com.colegio.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DistritoMapper {
	
	@JsonProperty("distritoId")
	private Integer distritoId;
	
	@JsonProperty("nombre")
	private String nombre;

	
	public DistritoMapper() {
		
	}


	public DistritoMapper(Integer distritoId, String nombre) {
		this.distritoId = distritoId;
		this.nombre = nombre;
	}




	public Integer getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(Integer distritoId) {
		this.distritoId = distritoId;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
