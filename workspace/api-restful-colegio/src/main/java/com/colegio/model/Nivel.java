package com.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "niveles")
public class Nivel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer nivelId;
	
	@Column
	private String nombre;

	@OneToMany(mappedBy = "nivel")
	private Collection<Grado> itemsgrado = new ArrayList<>();
	
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


	public Collection<Grado> getItemsgrado() {
		return itemsgrado;
	}


	public void setItemsgrado(Collection<Grado> itemsgrado) {
		this.itemsgrado = itemsgrado;
	}
	
	
}
