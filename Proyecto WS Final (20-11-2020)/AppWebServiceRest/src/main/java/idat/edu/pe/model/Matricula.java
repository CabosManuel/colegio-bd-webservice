package idat.edu.pe.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "matriculas")
public class Matricula implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer matriculaId;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column
	private Integer nivel;
	
	@Column
	private Integer grado;
	
	@Column
	private Integer seccion;
	
	@ManyToOne
	@JoinColumn(name = "aula_id", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(aula_id) references aulas(aula_id)" ))
	private Aula aula;
	
	@ManyToOne
	@JoinColumn(name = "estudiante_id", nullable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(estudiante_id) references estudiantes(estudiante_id)"))
	private Estudiante estudiante; 
	
	public Matricula() {
	}

	

	public Matricula(Integer matriculaId, Date fecha, Integer nivel, Integer grado, Integer seccion) {
		this.matriculaId = matriculaId;
		this.fecha = fecha;
		this.nivel = nivel;
		this.grado = grado;
		this.seccion = seccion;
	}



	@PrePersist
	public void pre() {
		fecha= new Date();
	}

	public Integer getMatriculaId() {
		return matriculaId;
	}

	public void setMatriculaId(Integer matriculaId) {
		this.matriculaId = matriculaId;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getGrado() {
		return grado;
	}

	public void setGrado(Integer grado) {
		this.grado = grado;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Integer getSeccion() {
		return seccion;
	}

	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}



	public Estudiante getEstudiante() {
		return estudiante;
	}



	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	
}
