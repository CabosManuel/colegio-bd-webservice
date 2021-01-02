package idat.edu.pe.mapper;

public class ApoderadoRespuestaMapper {
	private Boolean rpta;
	private String mensaje;
	private ApoderadoMapper apoderado;
	private String tipo;

	public ApoderadoRespuestaMapper() {
	}

	public ApoderadoRespuestaMapper(Boolean rpta, String mensaje, ApoderadoMapper apoderado, String tipo) {
		this.rpta = rpta;
		this.mensaje = mensaje;
		this.apoderado = apoderado;
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

	public ApoderadoMapper getApoderado() {
		return apoderado;
	}

	public void setApoderado(ApoderadoMapper apoderado) {
		this.apoderado = apoderado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
