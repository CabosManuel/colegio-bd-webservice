package idat.edu.pe.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "horario_cabecera")
public class HorarioCabecera implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer horarioCabeceraId;

	@Column
	private Boolean estado;

	@ManyToOne
	@JoinColumn(name = "seccion_id", nullable = false, updatable = false,
	foreignKey = @ForeignKey(foreignKeyDefinition = 
	"foreign key(seccion_id) references secciones(seccion_id)"))
	private Seccion seccion;
	
	@OneToMany(mappedBy = "horarioCabecera")
	private Collection<HorarioDetalle> horarioDetalle = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "trabajador_id", nullable = false, updatable=false,
	foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(trabajador_id) references trabajadores(trabajador_id)"))
	private Trabajador trabajador;

	public HorarioCabecera() {
	}

	public Integer getHorarioCabeceraId() {
		return horarioCabeceraId;
	}

	public void setHorarioCabeceraId(Integer horarioCabeceraId) {
		this.horarioCabeceraId = horarioCabeceraId;
	}

	public void sethorarioCabeceraId(Integer horarioCabeceraId) {
		this.horarioCabeceraId = horarioCabeceraId;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public Collection<HorarioDetalle> getHorarioDetalle() {
		return horarioDetalle;
	}

	public void setHorarioDetalle(Collection<HorarioDetalle> horarioDetalle) {
		this.horarioDetalle = horarioDetalle;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
}
