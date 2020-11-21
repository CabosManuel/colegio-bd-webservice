package idat.edu.pe.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="cursos")
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cursoId;
	
	@Column
	private String nombre;
	
	@Column 
	private Integer creditos;
	/*
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "Estudiantes_Cursos", joinColumns = @JoinColumn(
			name="estudiante_id", nullable=false,
			foreignKey=@ForeignKey(foreignKeyDefinition = "foreign key(estudiante_id) references estudiantes(estudiante_id)")),
	        inverseJoinColumns=@JoinColumn(name = "curso_id", nullable = false,
	        foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(curso_id) references cursos(curso_id)")))
	private Set<Estudiante> itemsEstudiante = new HashSet<>();*/
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "Profesores_Cursos", joinColumns = @JoinColumn(
			name="profesor_id", nullable=false,
			foreignKey=@ForeignKey(foreignKeyDefinition = "foreign key(profesor_id) references profesores(profesor_id)")),
	        inverseJoinColumns=@JoinColumn(name = "curso_id", nullable = false,
	        foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(curso_id) references cursos(curso_id)")))
	private Set<Estudiante> itemsProfesor = new HashSet<>();


	public Curso() {
	}

	public Curso(Integer cursoId, String nombre) {
		this.cursoId = cursoId;
		this.nombre = nombre;
	}

	public Integer getCursoId() {
		return cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}
/*
	public Set<Estudiante> getItemsEstudiante() {
		return itemsEstudiante;
	}

	public void setItemsEstudiante(Set<Estudiante> itemsEstudiante) {
		this.itemsEstudiante = itemsEstudiante;
	}
*/
	public Set<Estudiante> getItemsProfesor() {
		return itemsProfesor;
	}

	public void setItemsProfesor(Set<Estudiante> itemsProfesor) {
		this.itemsProfesor = itemsProfesor;
	}
	
	
	
	
	
}
