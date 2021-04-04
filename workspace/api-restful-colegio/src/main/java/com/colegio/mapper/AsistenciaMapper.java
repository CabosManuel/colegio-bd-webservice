package com.colegio.mapper;

import java.time.LocalDate;

public class AsistenciaMapper {
	private Boolean estado;
	private LocalDate fecha;

	public AsistenciaMapper() {
	}

	public AsistenciaMapper(Boolean estado, LocalDate fecha) {
		this.estado = estado;
		this.fecha = fecha;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
}
