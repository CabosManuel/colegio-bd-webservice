package idat.edu.pe.mapper;

public class EstudianteLoginMapper {
	private String dniEstudiante;
	private String nombre;
	private String apellido;
	private String fNacimiento;
	private String celular;
	private String correo;
	private String direccion;
	private Integer distritoId;
	private String dniApoderado;

	public EstudianteLoginMapper() {
	}

	public EstudianteLoginMapper(String dniEstudiante, String nombre, String apellido, String fNacimiento,
			String celular, String correo, String direccion, Integer distritoId, String dniApoderado) {
		this.dniEstudiante = dniEstudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fNacimiento = fNacimiento;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
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

	public String getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
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
