package com.colegio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "justificacion")
public class Justificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer justificacionId;

	@Column(length = 45, nullable = false)
	private String titulo;

	@Column(length = 1000, nullable = false)
	private String descripcion;

	//@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private LocalDate fechaJustificacion;

	@Column
	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaEnvio;

	@ManyToOne
	@JoinColumn(name = "matricula_id", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(matricula_id) references matricula(matricula_id)"))
	private Matricula matricula;

	public Justificacion() {
	}

	public Justificacion(Integer justificacionId, String titulo, String descripcion, LocalDate fechaJustificacion,
			LocalDateTime fechaEnvio) {
		this.justificacionId = justificacionId;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaJustificacion = fechaJustificacion;
		this.fechaEnvio = fechaEnvio;
	}

	public Integer getJustificacionId() {
		return justificacionId;
	}

	public void setJustificacionId(Integer justificacionId) {
		this.justificacionId = justificacionId;
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

	public LocalDate getFechaJustificacion() {
		return fechaJustificacion;
	}

	public void setFechaJustificacion(LocalDate fechaJustificacion) {
		this.fechaJustificacion = fechaJustificacion;
	}

	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

}
