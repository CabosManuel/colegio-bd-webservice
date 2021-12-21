package com.colegio.model;

import java.io.Serializable;
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
	private Integer id;

	@Column(columnDefinition = "tinyint", nullable = false)
	private Integer dia;

	@Column(columnDefinition = "tinyint", nullable = false)
	private Integer hora;

	@OneToMany(mappedBy = "horarioDetalle")
	private Collection<Asistencia> asistencias = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(id) references curso(id)"))
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "id_horario_cabecera", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(id) references horario_cabecera(id)"))
	private HorarioCabecera horarioCabecera;

	public HorarioDetalle() {
	}

	public HorarioDetalle(Integer id, Integer dia, Integer hora) {
		this.id = id;
		this.dia = dia;
		this.hora = hora;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Collection<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(Collection<Asistencia> asistencias) {
		this.asistencias = asistencias;
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

}
