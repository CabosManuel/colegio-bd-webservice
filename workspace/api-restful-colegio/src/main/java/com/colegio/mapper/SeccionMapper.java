package com.colegio.mapper;

public class SeccionMapper {

	private Integer seccionId;
	private String nombre;
	private GradoMapper grado;
	private String nombreSeccion;

	public SeccionMapper() {
	}

	public SeccionMapper(Integer seccionId) {
		this.seccionId = seccionId;
	}

	public SeccionMapper(Integer seccionId, String nombre) {
		this.seccionId = seccionId;
		this.nombre = nombre;
	}

	public SeccionMapper(Integer seccionId, String nombre, GradoMapper grado, String nombreSeccion) {
		this.seccionId = seccionId;
		this.nombre = nombre;
		this.grado = grado;
		this.nombreSeccion = nombreSeccion;
	}

	public Integer getSeccionId() {
		return seccionId;
	}

	public void setSeccionId(Integer seccionId) {
		this.seccionId = seccionId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public GradoMapper getGrado() {
		return grado;
	}

	public void setGrado(GradoMapper grado) {
		this.grado = grado;
	}

	public String getNombreSeccion() {
		return nombreSeccion;
	}

	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

}
