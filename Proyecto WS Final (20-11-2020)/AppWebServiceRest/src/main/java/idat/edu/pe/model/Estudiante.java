package idat.edu.pe.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="estudiantes")
public class Estudiante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int estudianteId;
	
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

	@ManyToOne
	@JoinColumn(name ="distrito_id", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(distrito_id) references distritos(distrito_id)"))
	private Distrito distrito;
	
	@ManyToMany(mappedBy = "itemsEstudiante", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Curso> itemsCurso = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name = "direccion_id", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(direccion_id) references direcciones(direccion_id)"))
	private Direccion direccion;
	
	public Estudiante() {
		
	}

	

	public Estudiante(int estudianteId, String nombre, String apellido, Long dni, int edad, String teléfono) {
		this.estudianteId = estudianteId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.teléfono = teléfono;
	}


	public int getEstudianteId() {
		return estudianteId;
	}

	public void setEstudianteId(int estudianteId) {
		this.estudianteId = estudianteId;
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

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	
	
}
