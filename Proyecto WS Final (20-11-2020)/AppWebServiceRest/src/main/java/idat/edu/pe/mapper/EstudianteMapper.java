package idat.edu.pe.mapper;

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
	private Integer estado;
	private DistritoMapper distrito;
	private ApoderadoMapper apoderado;
	
	public EstudianteMapper() {
	}

	public EstudianteMapper(String dniEstudiante, String nombre, String apellido, Date fnacimiento, String celular,
			String correo, String direccion, String pass, Integer estado, DistritoMapper distrito,
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
	}
	
	public EstudianteMapper(String dniEstudiante, String nombre, String apellido, Date fnacimiento, String celular,
			String correo, String direccion, String pass, Integer estado) {
		this.dniEstudiante = dniEstudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnacimiento = fnacimiento;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.pass = pass;
		this.estado = estado;
	}
	
	

	public EstudianteMapper(String dniEstudiante, String nombre, String apellido, Date fnacimiento, String celular,
			String correo, String direccion, Integer estado, DistritoMapper distrito) {
		this.dniEstudiante = dniEstudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fnacimiento = fnacimiento;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.estado = estado;
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

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
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

	
}
