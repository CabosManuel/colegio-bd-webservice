package idat.edu.pe.model;

import java.time.LocalTime;

import javax.persistence.*;

@Table
@Entity(name = "horario_detalle")
public class HorarioDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idHorarioDetalle;

	@Column
	private String dia;
	@Column
	private LocalTime horaInicio;
	@Column
	private LocalTime horaFin;
	@Column
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "id_horario_cabecera", nullable = false, 
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_horario_cabecera) references horario_cabecera(id_horario_cabecera)"))
	private HorarioCabecera horarioCabecera;

	public HorarioDetalle() {
	}

	public HorarioDetalle(Integer idHorarioDetalle, String dia, LocalTime horaInicio, LocalTime horaFin, Curso curso) {
		super();
		this.idHorarioDetalle = idHorarioDetalle;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.curso = curso;
	}

	public Integer getidHorarioDetalle() {
		return idHorarioDetalle;
	}

	public void setidHorarioDetalle(Integer idHorarioDetalle) {
		this.idHorarioDetalle = idHorarioDetalle;
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
