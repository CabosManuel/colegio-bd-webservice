package idat.edu.pe.mapper;

import java.time.LocalTime;

public class HorarioDetalleMapper {

	private Integer horarioDetalleId;
	private String dia;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private CursoMapper curso;
	private HorarioCabeceraMapper horarioCabecera;
	public HorarioDetalleMapper() {
	}
	public HorarioDetalleMapper(Integer horarioDetalleId) {
		this.horarioDetalleId = horarioDetalleId;
	}
	public HorarioDetalleMapper(Integer horarioDetalleId, String dia, LocalTime horaInicio, LocalTime horaFin,
			CursoMapper curso, HorarioCabeceraMapper horarioCabecera) {
		this.horarioDetalleId = horarioDetalleId;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.curso = curso;
		this.horarioCabecera = horarioCabecera;
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
	
	
}
