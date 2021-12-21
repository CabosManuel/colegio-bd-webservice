package com.colegio.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "estudiante")
public class Estudiante implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "char(8)")
	private String dni;

	@Column(length = 45, nullable = false)
	private String nombres;

	@Column(length = 45, nullable = false)
	private String apellidos;

	//@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private LocalDate fechaNacimiento;

	@Column(columnDefinition = "char(9)", unique = true, nullable = false)
	private String celular;

	@Column(length = 50, unique = true, nullable = false)
	private String correo;

	@Column(length = 32, nullable = false)
	private String password;

	@Column(length = 45, nullable = false)
	private String distrito;

	@Column(length = 50, nullable = false)
	private String direccion;

	@Column(nullable = false)
	private Boolean estado;

	@Column(length = 12, nullable = false)
	private String condicion;

	@OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<Matricula> matriculas = new ArrayList<>();

	public Estudiante() {
	}

	public Estudiante(String dniEstudiante) {
		this.dni = dniEstudiante;
	}

	public Estudiante(String dni, String nombres, String apellidos, LocalDate fechaNacimiento, String celular,
			String correo, String password, String distrito, String direccion, Boolean estado, String condicion) {
		this.dni = dni;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.celular = celular;
		this.correo = correo;
		this.password = password;
		this.distrito = distrito;
		this.direccion = direccion;
		this.estado = estado;
		this.condicion = condicion;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public Collection<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(Collection<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public String toString() {
		return "Estudiante [dni=" + dni + ", nombre=" + nombres + ", apellido=" + apellidos
				+ ", fnacimiento=" + fechaNacimiento + ", celular=" + celular + ", correo=" + correo + ", direccion="
				+ direccion + ", pass=" + password + ", estado=" + estado + ", condicion=" + condicion + ", distrito="
				+ distrito + "]";
	}

}
