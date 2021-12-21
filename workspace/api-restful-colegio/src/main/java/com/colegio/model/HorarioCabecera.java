package com.colegio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Integer id;

	@OneToMany(mappedBy = "horarioCabecera", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<HorarioDetalle> horariosDetalle = new ArrayList<>();

	public HorarioCabecera() {
	}

	public Integer geId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<HorarioDetalle> getHorariosDetalle() {
		return horariosDetalle;
	}

	public void setHorariosDetalle(Collection<HorarioDetalle> horariosDetalle) {
		this.horariosDetalle = horariosDetalle;
	}

}
