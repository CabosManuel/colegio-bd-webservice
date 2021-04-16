package com.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "horario_cabecera")
public class HorarioCabecera implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer horarioCabeceraId;

	@ManyToOne
	@JoinColumn(name = "seccion_id", nullable = false, updatable = true, foreignKey = @ForeignKey(
			foreignKeyDefinition = "foreign key(seccion_id) references seccion(seccion_id)"))
	private Seccion seccion;

	@OneToMany(mappedBy = "horarioCabecera", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<HorarioDetalle> horariosDetalle = new ArrayList<>();

	public HorarioCabecera() {
	}

	public Integer getHorarioCabeceraId() {
		return horarioCabeceraId;
	}

	public void setHorarioCabeceraId(Integer horarioCabeceraId) {
		this.horarioCabeceraId = horarioCabeceraId;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public Collection<HorarioDetalle> getHorariosDetalle() {
		return horariosDetalle;
	}

	public void setHorariosDetalle(Collection<HorarioDetalle> horariosDetalle) {
		this.horariosDetalle = horariosDetalle;
	}

}
