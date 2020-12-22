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
	
	@ManyToOne
	@JoinColumn(name = "seccion_id", nullable = false, updatable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(seccion_id) references secciones(seccion_id)"))
	private Seccion seccion;
	
	@ManyToOne
	@JoinColumn(name = "dni_estudiante", nullable = false, updatable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(dni_estudiante) references estudiantes(dni_estudiante)"))
	private Estudiante estudiante; 
	
	public Matricula() {
	}
	

	public Matricula(Integer matriculaId) {
		this.matriculaId = matriculaId;
	}


	public Matricula(Integer matriculaId, Date fecha, Integer nivel, Integer grado) {
		this.matriculaId = matriculaId;
		this.fecha = fecha;
		this.nivel = nivel;
		this.grado = grado;
	}

	public Matricula(Integer nivel, Integer grado, Seccion seccion, Estudiante estudiante) {
		this.nivel = nivel;
		this.grado = grado;
		this.seccion = seccion;
		this.estudiante = estudiante;
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

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	
}
