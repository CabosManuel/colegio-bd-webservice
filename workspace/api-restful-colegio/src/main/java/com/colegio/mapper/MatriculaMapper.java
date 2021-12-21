package com.colegio.mapper;

import java.util.Date;

public class MatriculaMapper {

	private Integer matriculaId;
	private Date fecha;
	private Integer nivel;
	private String nombrenivel;
	private Integer grado;
	private String nombregrado;
	private EstudianteMapper estudiante;

	public MatriculaMapper() {
	}

	public MatriculaMapper(Integer matriculaId) {
		this.matriculaId = matriculaId;
	}

//	public MatriculaMapper(Integer matriculaId, Date fecha, Integer nivel, String nombrenivel, Integer grado,
//			String nombregrado, SeccionMapper seccion, EstudianteMapper estudiante) {
//		this.matriculaId = matriculaId;
//		this.fecha = fecha;
//		this.nivel = nivel;
//		this.nombrenivel = nombrenivel;
//		this.grado = grado;
//		this.nombregrado = nombregrado;
//		this.seccion = seccion;
//		this.estudiante = estudiante;
//	}

	public Integer getMatriculaId() {
		return matriculaId;
	}

	public void setMatriculaId(Integer matriculaId) {
		this.matriculaId = matriculaId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getGrado() {
		return grado;
	}

	public void setGrado(Integer grado) {
		this.grado = grado;
	}

	public EstudianteMapper getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteMapper estudiante) {
		this.estudiante = estudiante;
	}

	public String getNombrenivel() {
		return nombrenivel;
	}

	public void setNombrenivel(String nombrenivel) {
		this.nombrenivel = nombrenivel;
	}

	public String getNombregrado() {
		return nombregrado;
	}

	public void setNombregrado(String nombregrado) {
		this.nombregrado = nombregrado;
	}

}
