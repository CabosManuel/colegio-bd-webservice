package com.colegio.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Table
@Entity(name = "horario_detalle")
public class HorarioDetalle implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer horarioDetalleId;

	@Column(length = 9, nullable = false)
	private String dia;

	//@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private LocalTime horaInicio;

	//@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private LocalTime horaFin;

	@OneToMany(mappedBy = "horarioDetalle")
	private Collection<Asistencia> asistencias = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(curso_id) references curso(curso_id)"))
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "horario_cabecera_id", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(horario_cabecera_id) references horario_cabecera(horario_cabecera_id)"))
	private HorarioCabecera horarioCabecera;

	public HorarioDetalle() {
	}

	public HorarioDetalle(Integer horarioDetalleId, String dia, LocalTime horaInicio, LocalTime horaFin, Curso curso) {
		this.horarioDetalleId = horarioDetalleId;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.curso = curso;
	}

	public Integer getHorarioDetalleId() {
		return horarioDetalleId;
	}

	public void setHorarioDetalleId(Integer horarioDetalleId) {
		this.horarioDetalleId = horarioDetalleId;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public HorarioCabecera getHorarioCabecera() {
		return horarioCabecera;
	}

	public void setHorarioCabecera(HorarioCabecera horarioCabecera) {
		this.horarioCabecera = horarioCabecera;
	}

	public Collection<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(Collection<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

}
