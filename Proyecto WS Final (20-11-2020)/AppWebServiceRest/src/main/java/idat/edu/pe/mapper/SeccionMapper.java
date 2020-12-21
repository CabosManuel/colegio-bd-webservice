package idat.edu.pe.mapper;

public class SeccionMapper {
	
	private Integer seccion_id;
	private String nombre;
	private GradoMapper grado_id;
	public SeccionMapper() {
	}
	public SeccionMapper(Integer seccion_id) {
		this.seccion_id = seccion_id;
	}
	
	public SeccionMapper(Integer seccion_id, String nombre) {
		this.seccion_id = seccion_id;
		this.nombre = nombre;
	}
	public SeccionMapper(Integer seccion_id, String nombre, GradoMapper grado_id) {
		this.seccion_id = seccion_id;
		this.nombre = nombre;
		this.grado_id = grado_id;
	}
	public Integer getSeccion_id() {
		return seccion_id;
	}
	public void setSeccion_id(Integer seccion_id) {
		this.seccion_id = seccion_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public GradoMapper getGrado_id() {
		return grado_id;
	}
	public void setGrado_id(GradoMapper grado_id) {
		this.grado_id = grado_id;
	}
	
	

}
