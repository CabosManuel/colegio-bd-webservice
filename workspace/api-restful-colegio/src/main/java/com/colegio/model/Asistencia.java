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
	private Integer asistenciaId;

	//@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private LocalDateTime horaAsistencia;

	@Column
	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "matricula_id", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(matricula_id) references matricula(matricula_id)"))
	private Matricula matricula;

	@ManyToOne
	@JoinColumn(name = "horario_detalle_id", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(horario_detalle_id) references horario_detalle(horario_detalle_id)"))
	private HorarioDetalle horarioDetalle;

	public Asistencia() {
	}

	public Asistencia(Integer asistenciaId, LocalDateTime horaAsistencia, Boolean estado) {
		this.asistenciaId = asistenciaId;
		this.horaAsistencia = horaAsistencia;
		this.estado = estado;
	}

	public Asistencia(Integer asistenciaId, LocalDateTime horaAsistencia, Boolean estado, Matricula matricula,
			HorarioDetalle horarioDetalle) {
		this.asistenciaId = asistenciaId;
		this.horaAsistencia = horaAsistencia;
		this.estado = estado;
		this.matricula = matricula;
		this.horarioDetalle = horarioDetalle;
	}

	public Integer getAsistenciaId() {
		return asistenciaId;
	}

	public void setAsistenciaId(Integer asistenciaId) {
		this.asistenciaId = asistenciaId;
	}

	public LocalDateTime getHoraAsistencia() {
		return horaAsistencia;
	}

	public void setHoraAsistencia(LocalDateTime horaAsistencia) {
		this.horaAsistencia = horaAsistencia;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
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
