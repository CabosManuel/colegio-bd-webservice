package idat.edu.pe.mapper;

import java.util.Date;

public class EstudianteMapper 
{	
	private Integer estudianteId;
	private String nombre;
	private String apellido;
	private Long dni;
	private Date fnacimiento;
	private String celular;
	private String correo;
	private String direccion;
	private String pass;
	private Integer estado;
	
	public EstudianteMapper() {
	}
	
	public EstudianteMapper(Integer estudianteId, String nombre, String apellido, Long dni, Date fnacimiento,
			String celular, String correo, String direccion, String pass, Integer estado) {
		this.estudianteId = estudianteId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fnacimiento = fnacimiento;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.pass = pass;
		this.estado = estado;
	}
	
	public Integer getEstudianteId() {
		return estudianteId;
	}
	
	public void setEstudianteId(Integer estudianteId) {
		this.estudianteId = estudianteId;
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
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
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
	
	
	

}
