package com.colegio.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "notificaciones")
public class Notificacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notificacionId;

	@Column
	private String tipo;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEnvio;
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaLimite;
	@Column
	private String titulo;
	@Column(length = 1000)
	private String descripcion;
	@Column
	private Character estado;

	@ManyToOne
	@JoinColumn(name = "dni_estudiante", nullable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(dni_estudiante) references estudiantes(dni_estudiante)"))
	private Estudiante dniEstudiante;

	public Notificacion() {
	}

	public Notificacion(Integer notificacionId, String tipo, Date fechaEnvio, Date fechaLimite, String titulo,
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

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
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

	public Estudiante getDniEstudiante() {
		return dniEstudiante;
	}

	public void setDniEstudiante(Estudiante dniEstudiante) {
		this.dniEstudiante = dniEstudiante;
	}
	
}
