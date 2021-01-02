package idat.edu.pe.mapper;

import javax.persistence.Column;

public class ApoderadoMapper {

	private String dniApoderado;
	private String nombre;
	private String apellido;
	private String correo;
	private String celular;
	private String direccion;
	private String pass;
	private Boolean estado;
	private DistritoMapper distrito;

	public ApoderadoMapper() {
	}
	
	public ApoderadoMapper(String dniApoderado) {
		this.dniApoderado = dniApoderado;
	}

	public ApoderadoMapper(String dniApoderado, String nombre, String apellido, String correo, String celular,
			String direccion, String pass, Boolean estado, DistritoMapper distrito) {
		this.dniApoderado = dniApoderado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.celular = celular;
		this.direccion = direccion;
		this.pass = pass;
		this.estado = estado;
		this.distrito = distrito;
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

	public DistritoMapper getDistrito() {
		return distrito;
	}

	public void setDistrito(DistritoMapper distrito) {
		this.distrito = distrito;
	}
	
}
