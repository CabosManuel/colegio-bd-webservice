package idat.edu.pe.model;

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
@Table(name = "justificaciones")
public class Justificacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer justificacionId;

	@Column
	private String titulo;
	@Column(length = 1000)
	private String descripcion;
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaJustificacion;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEnvio;
		
	@ManyToOne
	@JoinColumn(name = "dni_estudiante", nullable = false, updatable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(dni_estudiante) references estudiantes(dni_estudiante)"))
	private Estudiante dniEstudiante;
	
	public Justificacion() {
	}

	public Justificacion(Integer justificacionId, String titulo, String descripcion, Date fechaJustificacion,
			Date fechaEnvio) {
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

	public Date getFechaJustificacion() {
		return fechaJustificacion;
	}

	public void setFechaJustificacion(Date fechaJustificacion) {
		this.fechaJustificacion = fechaJustificacion;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Estudiante getDniEstudiante() {
		return dniEstudiante;
	}

	public void setDniEstudiante(Estudiante dniEstudiante) {
		this.dniEstudiante = dniEstudiante;
	}
}
