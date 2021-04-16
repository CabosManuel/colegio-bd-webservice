package com.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cursoId;

	@Column(length = 45, nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "curso")
	private Collection<Notas> notas = new ArrayList<>();

	@OneToMany(mappedBy = "curso")
	private Collection<HorarioDetalle> horariosDetalle = new ArrayList<>();

	@ManyToMany(mappedBy = "cursos", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Set<Trabajador> trabajadores = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "grado_id", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(grado_id) references grado(grado_id)"))
	private Grado grado;

	public Curso() {
	}

	public Curso(Integer cursoId, String nombre) {
		this.cursoId = cursoId;
		this.nombre = nombre;
	}

	public Integer getCursoId() {
		return cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Notas> getNotas() {
		return notas;
	}

	public void setNotas(Collection<Notas> notas) {
		this.notas = notas;
	}

	public Collection<HorarioDetalle> getHorariosDetalle() {
		return horariosDetalle;
	}

	public void setHorariosDetalle(Collection<HorarioDetalle> horariosDetalle) {
		this.horariosDetalle = horariosDetalle;
	}

}
