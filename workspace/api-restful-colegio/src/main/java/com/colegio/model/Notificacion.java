package com.colegio.model;

import java.io.Serializable;
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
@Table(name = "notificacion")
public class Notificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notificacionId;

	@Column(length = 10, nullable = false)
	private String tipo;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime fechaEnvio;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime fechaLimite;
	
	@Column(length = 45, nullable = false)
	private String titulo;
	
	@Column(length = 1000, nullable = false)
	private String descripcion;
	
	@Column(nullable = false)
	private Character estado;

	@ManyToOne
	@JoinColumn(name = "matricula_id", nullable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(matricula_id) references matricula(matricula_id)"))
	private Matricula matricula;

	public Notificacion() {
	}

	public Notificacion(Integer notificacionId, String tipo, LocalDateTime fechaEnvio, LocalDateTime fechaLimite, String titulo,
			String descripcion, Character estado) {
		this.notificacionId = notificacionId;
		this.tipo = tipo;
		this.fechaEnvio = fechaEnvio;
		this.fechaLimite = fechaLimite;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	public Integer getNotificacionId() {
		return notificacionId;
	}

	public void setNotificacionId(Integer notificacionId) {
		this.notificacionId = notificacionId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public LocalDateTime getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDateTime fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public LocalDateTime getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(LocalDateTime fechaLimite) {
		this.fechaLimite = fechaLimite;
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

	public Character getEstado() {
		return estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

}
