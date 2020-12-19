package idat.edu.pe.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "notas")
public class Nota implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer notaId;

	@Column
	private Integer nota1;
	@Column
	private Integer nota2;
	@Column
	private Integer nota3;
	@Column
	private String fecha;

	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false, updatable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(curso_id) references cursos(curso_id)"))
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "dni_estudiante", nullable = false, updatable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(dni_estudiante) references estudiantes(dni_estudiante)"))
	private Estudiante estudiante;

	public Nota() {
	}

	public Nota(Integer notaId, Integer nota1, Integer nota2, Integer nota3, String fecha) {
		super();
		this.notaId = notaId;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
		this.fecha = fecha;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

}
