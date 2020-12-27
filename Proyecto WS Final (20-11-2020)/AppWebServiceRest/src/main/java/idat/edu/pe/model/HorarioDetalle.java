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
	private LocalTime horaInicio;
	@Column
	private LocalTime horaFin;
	
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
	
	@OneToMany(mappedBy = "horarioDetalleId")
	private Collection<Asistencia> asistencias = new ArrayList<>();

	public HorarioDetalle() {
	}

	public HorarioDetalle(Integer horarioDetalleId, String dia, LocalTime horaInicio, LocalTime horaFin, Curso curso) {
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

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
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
}
