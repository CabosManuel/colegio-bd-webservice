package com.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false)
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "id_trabajador", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(id) references trabajador(id)"))
	private Trabajador trabajador;
	
	@OneToMany(mappedBy = "curso")
	private Collection<Notas> notas = new ArrayList<>();

	@OneToMany(mappedBy = "curso")
	private Collection<HorarioDetalle> horariosDetalle = new ArrayList<>();

	public Curso() {
	}

	public Curso(Integer id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
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
