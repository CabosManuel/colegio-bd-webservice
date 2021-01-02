package idat.edu.pe.mapper;

public class EstudianteRespuestaMapper {
	private Boolean rpta;
	private String mensaje;
	private EstudianteMapper estudiante;
	private String tipo;
	
	public EstudianteRespuestaMapper() {
	}
	
	public EstudianteRespuestaMapper(Boolean rpta, String mensaje, EstudianteMapper estudiante, String tipo) {
		this.rpta = rpta;
		this.mensaje = mensaje;
		this.estudiante = estudiante;
		this.tipo = tipo;
	}

	public Boolean getRpta() {
		return rpta;
	}

	public void setRpta(Boolean rpta) {
		this.rpta = rpta;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public EstudianteMapper getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(EstudianteMapper estudiante) {
		this.estudiante = estudiante;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
