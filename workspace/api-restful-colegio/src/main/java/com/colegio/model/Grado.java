package com.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "grado")
public class Grado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer gradoId;

	@Column(nullable = false)
	private Character nombre;

	@ManyToOne
	@JoinColumn(name = "nivel_id", nullable = false, updatable = false, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(nivel_id) references nivel(nivel_id)"))
	private Nivel nivel;

	@OneToMany(mappedBy = "grado")
	private Collection<Seccion> secciones = new ArrayList<>();

	@OneToMany(mappedBy = "grado")
	private Collection<Curso> cursos = new ArrayList<>();

	public Grado() {
	}

	public Grado(Integer gradoId, Character nombre) {
		this.gradoId = gradoId;
		this.nombre = nombre;
	}

	public Grado(Integer gradoId, Character nombre, Nivel nivel) {
		this.gradoId = gradoId;
		this.nombre = nombre;
		this.nivel = nivel;
	}

	public Integer getGradoId() {
		return gradoId;
	}

	public void setGradoId(Integer gradoId) {
		this.gradoId = gradoId;
	}

	public Character getNombre() {
		return nombre;
	}

	public void setNombre(Character nombre) {
		this.nombre = nombre;
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Collection<Seccion> getSecciones() {
		return secciones;
	}

	public void setSecciones(Collection<Seccion> secciones) {
		this.secciones = secciones;
	}

}
