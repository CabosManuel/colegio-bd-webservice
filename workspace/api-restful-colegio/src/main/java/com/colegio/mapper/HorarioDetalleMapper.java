package com.colegio.mapper;

public class HorarioDetalleMapper {

	private Integer horarioDetalleId;
	private String dia;
	private String horaInicio;
	private String horaFin;
	private CursoMapper curso;
	private Integer cursoId;
	private String nombreCurso;
	private TrabajadorMapper trabajador;
	private Integer trabajadorId;
	private HorarioCabeceraMapper horarioCabecera;

	public HorarioDetalleMapper() {
	}

	public HorarioDetalleMapper(Integer horarioDetalleId) {
		this.horarioDetalleId = horarioDetalleId;
	}

	public HorarioDetalleMapper(Integer horarioDetalleId, String dia, String horaInicio, String horaFin,
			CursoMapper curso, TrabajadorMapper trabajador, HorarioCabeceraMapper horarioCabecera) {
		this.horarioDetalleId = horarioDetalleId;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.curso = curso;
		this.trabajador = trabajador;
		this.horarioCabecera = horarioCabecera;
	}

	public HorarioDetalleMapper(Integer horarioDetalleId, String dia, String horaInicio, String horaFin,
			Integer cursoId, String nombreCurso, Integer trabajadorId) {
		this.horarioDetalleId = horarioDetalleId;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.cursoId = cursoId;
		this.nombreCurso = nombreCurso;
		this.trabajadorId = trabajadorId;
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

	public CursoMapper getCurso() {
		return curso;
	}

	public void setCurso(CursoMapper curso) {
		this.curso = curso;
	}

	public HorarioCabeceraMapper getHorarioCabecera() {
		return horarioCabecera;
	}

	public void setHorarioCabecera(HorarioCabeceraMapper horarioCabecera) {
		this.horarioCabecera = horarioCabecera;
	}

	public TrabajadorMapper getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(TrabajadorMapper trabajador) {
		this.trabajador = trabajador;
	}

	public Integer getCursoId() {
		return cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}

	public String getNombreCurso() {
		return nombreCurso;
	}

	public void setNombreCurso(String nombreCurso) {
		this.nombreCurso = nombreCurso;
	}

	public Integer getTrabajadorId() {
		return trabajadorId;
	}

	public void setTrabajadorId(Integer trabajadorId) {
		this.trabajadorId = trabajadorId;
	}

}
