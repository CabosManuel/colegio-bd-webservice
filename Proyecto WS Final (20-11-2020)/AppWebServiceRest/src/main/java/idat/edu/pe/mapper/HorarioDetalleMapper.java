package idat.edu.pe.mapper;

import java.time.LocalTime;

public class HorarioDetalleMapper {

	private Integer horarioDetalleId;
	private String dia;
	private String horaInicio;
	private String horaFin;
	private CursoMapper curso;
	private TrabajadorMapper trabajador;
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
	
}
