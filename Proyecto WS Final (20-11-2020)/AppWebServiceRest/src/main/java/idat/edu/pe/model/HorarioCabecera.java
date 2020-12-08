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
	private Integer idHorarioCabecera;

	@Column
	private Boolean estado;

	@OneToMany(mappedBy = "horarioCabecera")
	private Collection<HorarioDetalle> horarioDetalle = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "id_trabajador", nullable = false, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_trabajador) references trabajadores(id_trabajador)"))
	private Trabajador trabajador;

	public HorarioCabecera() {
	}

	public HorarioCabecera(Integer idHorarioCabecera, Boolean estado, Trabajador trabajador) {
		super();
		this.idHorarioCabecera = idHorarioCabecera;
		this.estado = estado;
	}

	public Integer getidHorarioCabecera() {
		return idHorarioCabecera;
	}

	public void setidHorarioCabecera(Integer idHorarioCabecera) {
		this.idHorarioCabecera = idHorarioCabecera;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

}
