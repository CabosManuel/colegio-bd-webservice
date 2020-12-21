package idat.edu.pe.mapper;

public class GradoMapper {
	
	private Integer grado_id;
	private String nombre;
	private NivelMapper nivel_id;
	
	public GradoMapper() {
	}
	public GradoMapper(Integer grado_id) {
		this.grado_id = grado_id;
	}
	public GradoMapper(Integer grado_id, String nombre, NivelMapper nivel_id) {
		this.grado_id = grado_id;
		this.nombre = nombre;
		this.nivel_id = nivel_id;
	}
	public Integer getGrado_id() {
		return grado_id;
	}
	public void setGrado_id(Integer grado_id) {
		this.grado_id = grado_id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public NivelMapper getNivel_id() {
		return nivel_id;
	}
	public void setNivel_id(NivelMapper nivel_id) {
		this.nivel_id = nivel_id;
	}
	
	

}
