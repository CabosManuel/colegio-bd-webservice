package com.colegio.mapper;

public class ApoderadoMapper {

	private String dniApoderado;
	private String nombre;
	private String apellido;
	private String correo;
	private String celular;
	private String direccion;
	private String pass;
	private Boolean estado;

	public ApoderadoMapper() {
	}

	public ApoderadoMapper(String dniApoderado) {
		this.dniApoderado = dniApoderado;
	}

	public ApoderadoMapper(String dniApoderado, String nombre, String apellido, String correo, String celular,
			String direccion, String pass, Boolean estado) {
		this.dniApoderado = dniApoderado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.celular = celular;
		this.direccion = direccion;
		this.pass = pass;
		this.estado = estado;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
