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
import javax.persistence.OneToMany;

@Entity
@Table(name = "nivel")
public class Nivel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nivelId;

	@Column(length = 10, unique = true, nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "nivel")
	private Collection<Grado> grados = new ArrayList<>();

	public Nivel() {
	}

	public Nivel(Integer nivelId, String nombre) {
		this.nivelId = nivelId;
		this.nombre = nombre;
	}

	public Integer getNivelId() {
		return nivelId;
	}

	public void setNivelId(Integer nivelId) {
		this.nivelId = nivelId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Grado> getGrados() {
		return grados;
	}

	public void setGrados(Collection<Grado> grados) {
		this.grados = grados;
	}

}
