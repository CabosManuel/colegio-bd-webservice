package com.colegio.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.util.Collection;

import javax.persistence.ForeignKey;

@Entity
@Table(name = "matricula")
public class Matricula implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matriculaId;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime fecha;

	@ManyToOne
	@JoinColumn(name = "dni_estudiante", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(dni_estudiante) references estudiante(dni_estudiante)"))
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name = "dni_apoderado", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(dni_apoderado) references apoderado(dni_apoderado)"))
	private Apoderado apoderado;

	@ManyToOne
	@JoinColumn(name = "seccion_id", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(seccion_id) references seccion(seccion_id)"))
	private Seccion seccion;

	@OneToMany(mappedBy = "matricula")
	private Collection<Notas> notas = new ArrayList<>();

	@OneToMany(mappedBy = "matricula")
	private Collection<Asistencia> asistencias = new ArrayList<>();

	@OneToMany(mappedBy = "matricula")
	private Collection<Notificacion> notificaciones = new ArrayList<>();

	@OneToMany(mappedBy = "matricula")
	private Collection<Justificacion> justificaciones = new ArrayList<>();

	public Matricula() {
	}

	public Matricula(Integer matriculaId) {
		this.matriculaId = matriculaId;
	}

	public Matricula(Integer matriculaId, LocalDateTime fecha) {
		this.matriculaId = matriculaId;
		this.fecha = fecha;
	}

	public Matricula(Seccion seccion, Estudiante estudiante) {
		this.seccion = seccion;
		this.estudiante = estudiante;
	}

	public Integer getMatriculaId() {
		return matriculaId;
	}

	public void setMatriculaId(Integer matriculaId) {
		this.matriculaId = matriculaId;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

}
