package idat.edu.pe.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="profesores")
public class Profesor implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profesorId;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
	
	@Column
	private Long dni;
	
	@Column
	private int edad;
	
	@Column
	private String teléfono;
	
	@ManyToMany(mappedBy = "itemsProfesor", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Curso> itemsCurso = new HashSet<>();

	public Profesor() {
	}

	public Profesor(int profesorId, String nombre, String apellido, Long dni, int edad, String teléfono) {
		this.profesorId = profesorId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.teléfono = teléfono;
	}

	public int getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(int profesorId) {
		this.profesorId = profesorId;
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTeléfono() {
		return teléfono;
	}

	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}

	public Set<Curso> getItemsCurso() {
		return itemsCurso;
	}

	public void setItemsCurso(Set<Curso> itemsCurso) {
		this.itemsCurso = itemsCurso;
	}
	
	


}
