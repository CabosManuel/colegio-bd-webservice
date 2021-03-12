package com.colegio.mapper;

import java.util.Date;

public class TrabajadorMapper {

	private Integer trabajadorId;
	private String cargo;
	private String nombres;
	private String apellidos;
	private String dni;
	private Date fechaNacimiento;
	private String celular;
	private String direccion;
	private String correo;
	private String pass;
	private Boolean estado;
	private DistritoMapper distrito;
	public TrabajadorMapper() {
	}
	public TrabajadorMapper(Integer trabajadorId) {
		this.trabajadorId = trabajadorId;
	}
	
	public TrabajadorMapper(Integer trabajadorId, String nombres, String apellidos) {
		this.trabajadorId = trabajadorId;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	public TrabajadorMapper(Integer trabajadorId, String cargo, String nombres, String apellidos, String dni,
			Date fechaNacimiento, String celular, String direccion, String correo, String pass, Boolean estado,
			DistritoMapper distrito) {
		this.trabajadorId = trabajadorId;
		this.cargo = cargo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.direccion = direccion;
		this.correo = correo;
		this.pass = pass;
		this.estado = estado;
		this.distrito = distrito;
	}
	public Integer getTrabajadorId() {
		return trabajadorId;
	}
	public void setTrabajadorId(Integer trabajadorId) {
		this.trabajadorId = trabajadorId;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public DistritoMapper getDistrito() {
		return distrito;
	}
	public void setDistrito(DistritoMapper distrito) {
		this.distrito = distrito;
	}
	public Boolean getEstado() {
		return estado;
	}
	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
