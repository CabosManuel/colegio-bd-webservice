package com.colegio.mapper;

public class JustificacionMapper {
	private Integer justificacionId;
	private String fechaEnvio;
	private String fechaJustificacion;
	private String titulo;
	private String descripcion;
	private String dniEstudiante;

	public JustificacionMapper() {
	}

	public JustificacionMapper(Integer justificacionId, String fechaEnvio, String fechaJustificacion, String titulo,
			String descripcion) {
		this.justificacionId = justificacionId;
		this.fechaEnvio = fechaEnvio;
		this.fechaJustificacion = fechaJustificacion;
		this.titulo = titulo;
		this.descripcion = descripcion;
	}

	public Integer getJustificacionId() {
		return justificacionId;
	}

	public void setJustificacionId(Integer justificacionId) {
		this.justificacionId = justificacionId;
	}

	public String getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getFechaJustificacion() {
		return fechaJustificacion;
	}

	public void setFechaJustificacion(String fechaJustificacion) {
		this.fechaJustificacion = fechaJustificacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDniEstudiante() {
		return dniEstudiante;
	}

	public void setDniEstudiante(String dniEstudiante) {
		this.dniEstudiante = dniEstudiante;
	}

}
