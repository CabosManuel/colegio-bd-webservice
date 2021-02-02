package idat.edu.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
	
	@Column
	private Integer horaCurso;
	
	@OneToMany(mappedBy = "curso")
	private Collection<Malla> mallas = new ArrayList<>(); 

	@OneToMany(mappedBy = "curso")
	private Collection<Nota> notas = new ArrayList<>();
	
	@OneToMany(mappedBy = "curso")
	private Collection<HorarioDetalle> horarios_detalle = new ArrayList<>();
	
	@ManyToMany(mappedBy = "itemsCurso", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Trabajador> itemsTrabajador = new HashSet<>();

	
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
	/*public Set<Estudiante> getItemsProfesor() {
		return itemsProfesor;
	}

	public void setItemsProfesor(Set<Estudiante> itemsProfesor) {
		this.itemsProfesor = itemsProfesor;
	}
	
	*/

	public Collection<Malla> getMallas() {
		return mallas;
	}

	public void setMallas(Collection<Malla> mallas) {
		this.mallas = mallas;
	}

	public Collection<Nota> getNotas() {
		return notas;
	}

	public void setNotas(Collection<Nota> notas) {
		this.notas = notas;
	}

	public Collection<HorarioDetalle> getHorarios_detalle() {
		return horarios_detalle;
	}

	public void setHorarios_detalle(Collection<HorarioDetalle> horarios_detalle) {
		this.horarios_detalle = horarios_detalle;
	}

	public Set<Trabajador> getItemsTrabajador() {
		return itemsTrabajador;
	}

	public void setItemsTrabajador(Set<Trabajador> itemsTrabajador) {
		this.itemsTrabajador = itemsTrabajador;
	}

	public Integer getHoraCurso() {
		return horaCurso;
	}

	public void setHoraCurso(Integer horaCurso) {
		this.horaCurso = horaCurso;
	}
	
}
