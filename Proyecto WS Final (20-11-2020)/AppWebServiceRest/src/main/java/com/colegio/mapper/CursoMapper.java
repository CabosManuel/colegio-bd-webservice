package com.colegio.mapper;

public class CursoMapper {
	
	private int curso_id;
	private String nombre;
	
	public CursoMapper() {
	}
	
	public CursoMapper(int curso_id, String nombre) {
		this.curso_id = curso_id;
		this.nombre = nombre;
	}
	
	public int getCurso_id() {
		return curso_id;
	}
	public void setCurso_id(int curso_id) {
		this.curso_id = curso_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
