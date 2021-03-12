package idat.edu.pe.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "asistencias")
public class Asistencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer asistenciaId;

	@Column
	private LocalDateTime asistencia;
	@Column
	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "dni_estudiante", nullable = false, updatable = false, 
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(dni_estudiante) references estudiantes(dni_estudiante)"))
	private Estudiante dniEstudiante;

	@ManyToOne
	@JoinColumn(name = "horario_detalle_id", nullable = false, updatable = false, 
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(horario_detalle_id) references horario_detalle(horario_detalle_id)"))
	private HorarioDetalle horarioDetalleId;

	public Asistencia() {
	}

	public Asistencia(Integer asistenciaId, LocalDateTime asistencia, Boolean estado) {
		this.asistenciaId = asistenciaId;
		this.asistencia = asistencia;
		this.estado = estado;
	}
	
	
	
	public Asistencia(Integer asistenciaId, LocalDateTime asistencia, Boolean estado, Estudiante dniEstudiante,
			HorarioDetalle horarioDetalleId) {
	
		this.asistenciaId = asistenciaId;
		this.asistencia = asistencia;
		this.estado = estado;
		this.dniEstudiante = dniEstudiante;
		this.horarioDetalleId = horarioDetalleId;
	}

	@PrePersist
	public void pre() {
		LocalDate hoy = LocalDate.now();
		LocalTime ahora = LocalTime.now();
		asistencia= LocalDateTime.of(hoy, ahora);
	}

	public Integer getAsistenciaId() {
		return asistenciaId;
	}

	public void setAsistenciaId(Integer asistenciaId) {
		this.asistenciaId = asistenciaId;
	}

	public LocalDateTime getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(LocalDateTime asistencia) {
		this.asistencia = asistencia;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Estudiante getDniEstudiante() {
		return dniEstudiante;
	}

	public void setDniEstudiante(Estudiante dniEstudiante) {
		this.dniEstudiante = dniEstudiante;
	}

	public HorarioDetalle getHorarioDetalleId() {
		return horarioDetalleId;
	}

	public void setHorarioDetalleId(HorarioDetalle horarioDetalleId) {
		this.horarioDetalleId = horarioDetalleId;
	}

}
