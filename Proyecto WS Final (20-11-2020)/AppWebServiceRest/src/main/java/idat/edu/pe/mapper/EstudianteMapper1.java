package idat.edu.pe.mapper;

import java.util.Date;
import java.util.Map;

import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Distrito;

public class EstudianteMapper1 
{	
	private String dniEstudiante;
	private String nombre;
	private String apellido;
	private String fnacimiento;
	private String celular;
	private String correo;
	private String direccion;
	private String pass;
	private Boolean estado;
	private String condicion;
	private String nombreDistrito;
	private Integer distritoId;
	private String dniApoderado;
	
	public EstudianteMapper1() {
	}	

	public EstudianteMapper1(String dniEstudiante) {
		this.dniEstudiante = dniEstudiante;
	}

	
	/*public EstudianteMapper1(String dniEstudiante, String nombre, String apellido, String fnacimiento, String celular,
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
	*/
	

	public EstudianteMapper1(String dniEstudiante, String nombre, String apellido, String fnacimiento, String celular,
			String correo, String direccion, String pass, Boolean estado, String distrito, Integer distritoId, String apoderado) {
		this.dniEstudiante = dniEstudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnacimiento = fnacimiento;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.pass = pass;
		this.estado = estado;
		this.nombreDistrito = distrito;
		this.distritoId = distritoId;
		this.dniApoderado = apoderado;
	}

	public EstudianteMapper1(String dniEstudiante, String nombre, String apellido, String fnacimiento, String celular,
			String correo, String direccion, String pass, Boolean estado, String condicion, String nombreDistrito,
			Integer distritoId, String dniApoderado) {
		
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
		this.nombreDistrito = nombreDistrito;
		this.distritoId = distritoId;
		this.dniApoderado = dniApoderado;
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

	public String getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(String fnacimiento) {
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



	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String distrito) {
		this.nombreDistrito = distrito;
	}

	public String getDniApoderado() {
		return dniApoderado;
	}
	
	public void setDniApoderado(String apoderado) {
		this.dniApoderado = apoderado;
	}

	public Integer getDistritoId() {
		return distritoId;
	}

	public void setDistritoId(Integer distritoId) {
		this.distritoId = distritoId;
	}
	
	

}
