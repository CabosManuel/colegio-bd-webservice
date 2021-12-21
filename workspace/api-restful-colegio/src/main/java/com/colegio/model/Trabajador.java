package com.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity(name = "trabajador")
public class Trabajador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trabajadorId;

	@Column(length = 20, nullable = false)
	private String cargo;

	@Column(length = 45, nullable = false)
	private String nombres;

	@Column(length = 45, nullable = false)
	private String apellidos;

	@Column(columnDefinition = "char(8)", unique = true, nullable = false)
	private String dni;

	//@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaNacimiento;

	@Column(columnDefinition = "char(1)", nullable = false)
	private String sexo;

	@Column(columnDefinition = "char(9)", unique = true, nullable = false)
	private String celular;

	@Column(length = 45, nullable = false)
	private String distrito;

	@Column(length = 50)
	private String direccion;

	@Column(length = 50, unique = true, nullable = false)
	private String correo;

	@Column(length = 32, nullable = false)
	private String password;

	@Column(nullable = false)
	private Boolean estado;

	@OneToMany(mappedBy = "trabajador")
	private Collection<Curso> cursos = new ArrayList<>();

	public Trabajador() {
	}

	public Trabajador(Integer trabajadorId, String cargo, String nombres, String apellidos, String dni,
			Date fechaNacimiento, String sexo, String celular, String distrito, String direccion, String correo,
			String password, Boolean estado) {
		this.trabajadorId = trabajadorId;
		this.cargo = cargo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.celular = celular;
		this.distrito = distrito;
		this.direccion = direccion;
		this.correo = correo;
		this.password = password;
		this.estado = estado;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Collection<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Collection<Curso> cursos) {
		this.cursos = cursos;
	}

}
