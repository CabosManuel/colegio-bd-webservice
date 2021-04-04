package com.colegio.mapper;

import java.util.Collection;
import java.util.Map;

public class ApoderadoLoginMapper {
	private String dniApoderado;
	private String nombre;
	private String apellido;
	private String correo;
	private String celular;
	private String direccion;
	private Integer distritoId;
	private Collection<Map<String, ?>> estudiantes;

	public ApoderadoLoginMapper() {
	}

	public ApoderadoLoginMapper(String dniApoderado, String nombre, String apellido, String correo, String celular,
			String direccion, Integer distritoId) {
		this.dniApoderado = dniApoderado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.celular = celular;
		this.direccion = direccion;
		this.distritoId = distritoId;
	}

	public String getDniApoderado() {
		return dniApoderado;
	}

	public void setDniApoderado(String dniApoderado) {
		this.dniApoderado = dniApoderado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public Integer getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(Integer distritoId) {
		this.distritoId = distritoId;
	}

	public Collection<Map<String, ?>> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Collection<Map<String, ?>> estudiantes) {
		this.estudiantes = estudiantes;
	}
}
