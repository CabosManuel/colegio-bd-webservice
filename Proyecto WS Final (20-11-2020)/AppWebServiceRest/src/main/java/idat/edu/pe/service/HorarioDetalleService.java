package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

import idat.edu.pe.model.HorarioDetalle;

public interface HorarioDetalleService{
	
	public abstract void insert(HorarioDetalle horarioDetalle);
	public abstract void update(HorarioDetalle horarioDetalle);
	Collection<Map<String, ?>> getfindBySeccion(Integer seccionId, Integer trabajadorId);
	public abstract HorarioDetalle findById(Integer horarioDetalleId);
	Collection<Map<String, ?>> findHorarioByDni(String dniEstudiante);
	Collection<Map<String, ?>> buscarHorarioPorSeccion(Integer seccionId);
}
