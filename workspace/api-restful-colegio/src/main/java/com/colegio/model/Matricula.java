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
	private Integer id;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime fecha;
	
	@Column(nullable = false)
	private Character nivel;
	
	@Column(columnDefinition = "tinyint", nullable = false)
	private int grado;
	
	@Column(nullable = false)
	private Character seccion;

	@ManyToOne
	@JoinColumn(name = "dni_estudiante", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(dni) references estudiante(dni)"))
	private Estudiante estudiante;
	
	@ManyToOne
	@JoinColumn(name = "dni_apoderado", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(dni) references apoderado(dni)"))
	private Apoderado apoderado;
	
	@ManyToOne
	@JoinColumn(name = "horario_cabecera_id", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(id) references horario_cabecera(id)"))
	private HorarioCabecera horarioCabecera;

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

	public Matricula(Integer id) {
		this.id = id;
	}

	public Matricula(Integer id, LocalDateTime fecha, Character nivel, int grado, Character seccion) {
		this.id = id;
		this.fecha = fecha;
		this.nivel = nivel;
		this.grado = grado;
		this.seccion = seccion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Character getNivel() {
		return nivel;
	}

	public void setNivel(Character nivel) {
		this.nivel = nivel;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public Character getSeccion() {
		return seccion;
	}

	public void setSeccion(Character seccion) {
		this.seccion = seccion;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Apoderado getApoderado() {
		return apoderado;
	}

	public void setApoderado(Apoderado apoderado) {
		this.apoderado = apoderado;
	}

	public HorarioCabecera getHorarioCabecera() {
		return horarioCabecera;
	}

	public void setHorarioCabecera(HorarioCabecera horarioCabecera) {
		this.horarioCabecera = horarioCabecera;
	}

	public Collection<Notas> getNotas() {
		return notas;
	}

	public void setNotas(Collection<Notas> notas) {
		this.notas = notas;
	}

	public Collection<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(Collection<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Collection<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(Collection<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public Collection<Justificacion> getJustificaciones() {
		return justificaciones;
	}

	public void setJustificaciones(Collection<Justificacion> justificaciones) {
		this.justificaciones = justificaciones;
	}

}
