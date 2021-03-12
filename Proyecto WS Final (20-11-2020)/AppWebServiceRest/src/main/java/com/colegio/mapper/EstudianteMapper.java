package com.colegio.mapper;

import java.util.Date;

public class EstudianteMapper 
{	
	private String dniEstudiante;
	private String nombre;
	private String apellido;
	private Date fnacimiento;
	private String celular;
	private String correo;
	private String direccion;
	private String pass;
	private Boolean estado;
	private String condicion;
	private DistritoMapper distrito;
	private Integer distritoId;
	private ApoderadoMapper apoderado;
	private String dniApoderado;
	
	public EstudianteMapper() {
	}
	
	public EstudianteMapper(String dniEstudiante) {
		this.dniEstudiante = dniEstudiante;
	}

	public EstudianteMapper(String dniEstudiante, String nombre, String apellido, Date fnacimiento, String celular,
			String correo, String direccion, String pass, Boolean estado, String condicion, DistritoMapper distrito,
			ApoderadoMapper apoderado) {
		this.dniEstudiante = dniEstudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnacimiento = fnacimiento;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.pass = pass;
		this.estado = estado;
		this.distrito = distrito;
		this.apoderado = apoderado;
		this.condicion = condicion;
	}
	
	public EstudianteMapper(String dniEstudiante, String nombre, String apellido, Date fnacimiento, String celular,
			String correo, String direccion, String pass, Boolean estado, String condicion) {
		this.dniEstudiante = dniEstudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnacimiento = fnacimiento;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.pass = pass;
		this.estado = estado;
		this.condicion = condicion;
	}
	
	

	public EstudianteMapper(String dniEstudiante, String nombre, String apellido, Date fnacimiento, String celular,
			String correo, String direccion, Boolean estado, String condicion, Integer distritoId,
			String dniApoderado) {
		this.dniEstudiante = dniEstudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnacimiento = fnacimiento;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		//this.pass = pass;
		this.estado = estado;
		this.condicion = condicion;
		this.distritoId = distritoId;
		this.dniApoderado = dniApoderado;
	}



	public EstudianteMapper(String dniEstudiante, String nombre, String apellido, Date fnacimiento, String celular,
			String correo, String direccion, Boolean estado, String condicion, DistritoMapper distrito) {
		this.dniEstudiante = dniEstudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnacimiento = fnacimiento;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.estado = estado;
		this.condicion = condicion;
		this.distrito = distrito;
	}

	public String getDniEstudiante() {
		return dniEstudiante;
	}

	public void setDniEstudiante(String dniEstudiante) {
		this.dniEstudiante = dniEstudiante;
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

	public Date getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(Date fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}

	public DistritoMapper getDistrito() {
		return distrito;
	}

	public void setDistrito(DistritoMapper distrito) {
		this.distrito = distrito;
	}

	public ApoderadoMapper getApoderado() {
		return apoderado;
	}

	public void setApoderado(ApoderadoMapper apoderado) {
		this.apoderado = apoderado;
	}



	public Integer getDistritoId() {
		return distritoId;
	}



	public void setDistritoId(Integer distritoId) {
		this.distritoId = distritoId;
	}



	public String getDniApoderado() {
		return dniApoderado;
	}



	public void setDniApoderado(String dniApoderado) {
		this.dniApoderado = dniApoderado;
	}

	
}
