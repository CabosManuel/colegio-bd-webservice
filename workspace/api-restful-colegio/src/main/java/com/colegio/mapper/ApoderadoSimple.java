package com.colegio.mapper;

import java.util.Collection;
import java.util.Map;

public class ApoderadoSimple {
	private String dni;
	private String nombres;
	private String apellidos;
	private String correo;
	private String celular;
	private String direccion;
	private String distrito;
	private Collection<Map<String, ?>> estudiantes;

	public ApoderadoSimple() {
	}

	public ApoderadoSimple(String dni, String nombre, String apellido, String correo, String celular,
			String direccion, String distritoId) {
		this.dni = dni;
		this.nombres = nombre;
		this.apellidos = apellido;
		this.correo = correo;
		this.celular = celular;
		this.direccion = direccion;
		this.distrito = distritoId;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distritoId) {
		this.distrito = distritoId;
	}

	public Collection<Map<String, ?>> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Collection<Map<String, ?>> estudiantes) {
		this.estudiantes = estudiantes;
	}
}
