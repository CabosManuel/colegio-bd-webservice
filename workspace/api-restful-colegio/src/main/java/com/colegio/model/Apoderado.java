package com.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;

@Entity
@Table(name = "apoderado")
public class Apoderado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "char(8)")
	private String dniApoderado;

	@Column(length = 45, nullable = false)
	private String nombres;

	@Column(length = 45, nullable = false)
	private String apellidos;

	@Column(length = 50, unique = true, nullable = false)
	private String correo;

	@Column(columnDefinition = "char(9)", nullable = false, unique = true)
	private String celular;

	@Column(length = 32, nullable = false)
	private String password;

	@Column(length = 45, nullable = false)
	private String distrito;

	@Column(length = 50, nullable = false)
	private String direccion;

	@Column(nullable = false)
	private Boolean estado;
	
	@OneToMany(mappedBy = "apoderado", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<Matricula> matriculas = new ArrayList<>();
	
	public Apoderado() {
	}

	public Apoderado(String dniApoderado) {
		this.dniApoderado = dniApoderado;
	}

	public Apoderado(String dniApoderado, String nombre, String apellido, String correo, String celular, String pass,
			String distrito, String direccion, Boolean estado) {
		this.dniApoderado = dniApoderado;
		this.nombres = nombre;
		this.apellidos = apellido;
		this.correo = correo;
		this.celular = celular;
		this.password = pass;
		this.distrito = distrito;
		this.direccion = direccion;
		this.estado = estado;
	}

	public String getDniApoderado() {
		return dniApoderado;
	}

	public void setDniApoderado(String dniApoderado) {
		this.dniApoderado = dniApoderado;
	}

	public String getNombre() {
		return nombres;
	}

	public void setNombre(String nombre) {
		this.nombres = nombre;
	}

	public String getApellido() {
		return apellidos;
	}

	public void setApellido(String apellido) {
		this.apellidos = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String pass) {
		this.password = pass;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}
