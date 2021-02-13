package idat.edu.pe.mapper;

public class NotificacionMapper {

	private Integer idNofiticacion;
	private String tipo;
	private String fechaEnvio;
	private String fechaLimite;
	private String titulo;
	private String descripcion;
	private Character estado;
	private String dniEstudiante;

	public NotificacionMapper() {
	}

	public NotificacionMapper(Integer idNofiticacion, String tipo, String fechaEnvio, String titulo,
			String descripcion, String dniEstudiante) {
		this.idNofiticacion = idNofiticacion;
		this.tipo = tipo;
		this.fechaEnvio = fechaEnvio;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.dniEstudiante = dniEstudiante;
	}
	
	public NotificacionMapper(Integer idNofiticacion, String tipo, String fechaEnvio, String fechaLimite, String titulo,
			String descripcion, Character estado, String dniEstudiante) {
		this.idNofiticacion = idNofiticacion;
		this.tipo = tipo;
		this.fechaEnvio = fechaEnvio;
		this.fechaLimite = fechaLimite;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.dniEstudiante = dniEstudiante;
	}

	public Integer getIdNofiticacion() {
		return idNofiticacion;
	}

	public void setIdNofiticacion(Integer idNofiticacion) {
		this.idNofiticacion = idNofiticacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(String fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Character getEstado() {
		return estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	public String getDniEstudiante() {
		return dniEstudiante;
	}

	public void setDniEstudiante(String dniEstudiante) {
		this.dniEstudiante = dniEstudiante;
	}
	
}
