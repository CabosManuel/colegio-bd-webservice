package idat.edu.pe.service;

import java.util.Collection;

import idat.edu.pe.model.HorarioDetalle;

public interface HorarioDetalleService{
	
	public abstract void insert(HorarioDetalle horarioDetalle);
	public Collection<HorarioDetalle> getfindBySeccion(Integer seccionId, Integer trabajadorId);

}
