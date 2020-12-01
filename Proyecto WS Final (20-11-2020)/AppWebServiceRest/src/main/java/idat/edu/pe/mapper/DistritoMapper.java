package idat.edu.pe.mapper;

public class DistritoMapper {
	
	private Integer distritoId;
	
	private String nombre;

	
	public DistritoMapper(Integer distritoId) {
		this.distritoId = distritoId;
	}


	public DistritoMapper(Integer distritoId, String nombre) {
		this.distritoId = distritoId;
		this.nombre = nombre;
	}


	public Integer getDistritoId() {
		return distritoId;
	}


	public void setDistritoId(Integer distritoId) {
		this.distritoId = distritoId;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}
