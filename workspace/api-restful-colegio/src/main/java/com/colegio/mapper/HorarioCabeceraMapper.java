package com.colegio.mapper;

public class HorarioCabeceraMapper {

	private Integer horarioCabeceraId;
	private Boolean estado;
	private TrabajadorMapper trabajador;

	public HorarioCabeceraMapper() {
	}

	public HorarioCabeceraMapper(Integer horarioCabeceraId) {
		this.horarioCabeceraId = horarioCabeceraId;
	}

//	public HorarioCabeceraMapper(Integer horarioCabeceraId, Boolean estado, SeccionMapper seccion,
//			TrabajadorMapper trabajador) {
//		this.horarioCabeceraId = horarioCabeceraId;
//		this.estado = estado;
//		this.seccion = seccion;
//		this.trabajador = trabajador;
//	}

	public Integer getHorarioCabeceraId() {
		return horarioCabeceraId;
	}

	public void setHorarioCabeceraId(Integer horarioCabeceraId) {
		this.horarioCabeceraId = horarioCabeceraId;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public TrabajadorMapper getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(TrabajadorMapper trabajador) {
		this.trabajador = trabajador;
	}

}
