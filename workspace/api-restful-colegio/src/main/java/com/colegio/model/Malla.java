package com.colegio.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "mallas")
public class Malla implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mallaId;
	
	@ManyToOne
	@JoinColumn(name = "grado_id", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(grado_id) references grados(grado_id)"))
	private Grado grado;
	
	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(curso_id) references cursos(curso_id)"))
	private Curso curso;

	public Malla() {
	}

	public Malla(Integer mallaId) {
		this.mallaId = mallaId;
	}

	public Integer getMallaId() {
		return mallaId;
	}

	public void setMallaId(Integer mallaId) {
		this.mallaId = mallaId;
	}

	public Grado getGrado() {
		return grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
