package idat.edu.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "distritos")
public class Distrito implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer distritoId;
	
	@Column
	private String nombre;
	
	@OneToMany(mappedBy = "distrito",cascade = CascadeType.ALL ,fetch =FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
	private  Collection<Estudiante> estudiantes = new ArrayList<>();

	public Distrito() {
	}

	
	public Distrito(Integer distritoId) {
		this.distritoId = distritoId;
	}


	public Distrito(Integer distritoId, String nombre) {
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

	public Collection<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Collection<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	
	
	
	
	
}
