package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import com.colegio.model.HorarioDetalle;

public interface HorarioDetalleService{
	
	public abstract void insert(HorarioDetalle horarioDetalle);
	public abstract void update(HorarioDetalle horarioDetalle);
	Collection<Map<String, ?>> getfindBySeccion(Integer seccionId, Integer trabajadorId);
	public abstract HorarioDetalle findById(Integer horarioDetalleId);
	Collection<Map<String, ?>> findHorarioByDni(String dniEstudiante);
	Collection<Map<String, ?>> buscarHorarioPorSeccion(Integer seccionId);
	void registrarHorarioDetalle(String dia, String horaFin, String horaInicio, String cursoId, String trabajadorId, String horario_cabecera_id);
	void modificarHorarioDetalle(String dia, String horaFin, String horaInicio, String cursoId, String trabajadorId, Integer horario_detalle_id);
}
