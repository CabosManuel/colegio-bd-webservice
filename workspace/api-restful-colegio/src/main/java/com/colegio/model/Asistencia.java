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
@Table(name = "asistencia")
public class Asistencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime fecha;

	@Column(nullable = false)
	private Boolean asistencia;

	@ManyToOne
	@JoinColumn(name = "id_matricula", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(id) references matricula(id)"))
	private Matricula matricula;

	@ManyToOne
	@JoinColumn(name = "id_horario_detalle", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(id) references horario_detalle(id)"))
	private HorarioDetalle horarioDetalle;

	public Asistencia() {
	}

	public Asistencia(Integer id, LocalDateTime fecha, Boolean asistencia) {
		this.id = id;
		this.fecha = fecha;
		this.asistencia = asistencia;
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

	public Boolean getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Boolean asistencia) {
		this.asistencia = asistencia;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public HorarioDetalle getHorarioDetalle() {
		return horarioDetalle;
	}

	public void setHorarioDetalle(HorarioDetalle horarioDetalle) {
		this.horarioDetalle = horarioDetalle;
	}

}
