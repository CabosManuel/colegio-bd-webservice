package com.colegio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ForeignKey;

@Entity
@Table(name = "notas")
public class Notas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(columnDefinition = "tinyint", nullable = false)
	private Integer nota1;

	@Column(columnDefinition = "tinyint", nullable = false)
	private Integer nota2;

	@Column(columnDefinition = "tinyint", nullable = false)
	private Integer nota3;

	@ManyToOne
	@JoinColumn(name = "id_curso", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(id) references curso(id)"))
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "id_matricula", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(id) references matricula(id)"))
	private Matricula matricula;

	public Notas() {
	}

	public Notas(Integer id, Integer nota1, Integer nota2, Integer nota3) {
		this.id = id;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNota1() {
		return nota1;
	}

	public void setNota1(Integer nota1) {
		this.nota1 = nota1;
	}

	public Integer getNota2() {
		return nota2;
	}

	public void setNota2(Integer nota2) {
		this.nota2 = nota2;
	}

	public Integer getNota3() {
		return nota3;
	}

	public void setNota3(Integer nota3) {
		this.nota3 = nota3;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

}
