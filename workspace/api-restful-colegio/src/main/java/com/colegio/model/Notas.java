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
	private Integer notaId;

	@Column(columnDefinition = "tinyint")
	private Integer nota1;

	@Column(columnDefinition = "tinyint")
	private Integer nota2;

	@Column(columnDefinition = "tinyint")
	private Integer nota3;

	@ManyToOne
	@JoinColumn(name = "seccion_id", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(seccion_id) references seccion(seccion_id)"))
	private Seccion seccion;

	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(curso_id) references curso(curso_id)"))
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "matricula_id", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(matricula_id) references matricula(matricula_id)"))
	private Matricula matricula;

	public Notas() {
	}

	public Notas(Integer notaId, Integer nota1, Integer nota2, Integer nota3) {
		this.notaId = notaId;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}

	public Integer getNotaId() {
		return notaId;
	}

	public void setNotaId(Integer notaId) {
		this.notaId = notaId;
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

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
}
