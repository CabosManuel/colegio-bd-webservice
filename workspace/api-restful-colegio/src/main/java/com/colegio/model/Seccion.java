package com.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ForeignKey;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "seccion")
public class Seccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer seccionId;

	@Column(nullable = false)
	private Character nombre;

	@ManyToOne
	@JoinColumn(name = "grado_id", nullable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(grado_id) references grado(grado_id)"))
	private Grado grado;

	@OneToMany(mappedBy = "seccion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<Matricula> matriculas = new ArrayList<>();

	@OneToMany(mappedBy = "seccion")
	private Collection<HorarioCabecera> horariosCabecera = new ArrayList<>();

	@OneToMany(mappedBy = "seccion")
	private Collection<Notas> notas = new ArrayList<>();

	public Seccion() {
	}

	public Seccion(Integer seccionId, Character nombre) {
		this.seccionId = seccionId;
		this.nombre = nombre;
	}

	public Seccion(Integer seccionId, Character nombre, Grado grado) {
		this.seccionId = seccionId;
		this.nombre = nombre;
		this.grado = grado;
	}

	public Integer getSeccionId() {
		return seccionId;
	}

	public void setSeccionId(Integer seccionId) {
		this.seccionId = seccionId;
	}

	public Character getNombre() {
		return nombre;
	}

	public void setNombre(Character nombre) {
		this.nombre = nombre;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Collection<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Collection<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Collection<HorarioCabecera> getHorariosCabecera() {
		return horariosCabecera;
	}

	public void setHorariosCabecera(Collection<HorarioCabecera> horariosCabecera) {
		this.horariosCabecera = horariosCabecera;
	}

	public Collection<Notas> getNotas() {
		return notas;
	}

	public void setNotas(Collection<Notas> notas) {
		this.notas = notas;
	}

}
