package idat.edu.pe.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Table
@Entity(name = "horario_detalle")
public class HorarioDetalle implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer horarioDetalleId;

	@Column
	private String dia;
	
	@Column
	private String horaInicio;
	
	@Column
	private String horaFin;
	
	@ManyToOne
	@JoinColumn(name ="curso_id", nullable = false, updatable =false,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(curso_id) references cursos(curso_id)"))
	private Curso curso;

	@ManyToOne
	@JoinColumn(name ="horario_cabecera_id", nullable = false, updatable =false,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(horario_cabecera_id) references horario_cabecera(horario_cabecera_id)"))
	private HorarioCabecera horarioCabecera;
	
	@ManyToOne
	@JoinColumn(name = "trabajador_id", nullable = false, updatable=false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(trabajador_id) references trabajadores(trabajador_id)"))
	private Trabajador trabajador;
	
	@OneToMany(mappedBy = "horarioDetalleId")
	private Collection<Asistencia> asistencias = new ArrayList<>();

	public HorarioDetalle() {
	}

	public HorarioDetalle(Integer horarioDetalleId, String dia, String horaInicio, String horaFin, Curso curso) {
		this.horarioDetalleId = horarioDetalleId;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.curso = curso;
	}

	public Integer getHorarioDetalleId() {
		return horarioDetalleId;
	}

	public void setHorarioDetalleId(Integer horarioDetalleId) {
		this.horarioDetalleId = horarioDetalleId;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public HorarioCabecera getHorarioCabecera() {
		return horarioCabecera;
	}

	public void setHorarioCabecera(HorarioCabecera horarioCabecera) {
		this.horarioCabecera = horarioCabecera;
	}

	public Collection<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(Collection<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}	
	
}
