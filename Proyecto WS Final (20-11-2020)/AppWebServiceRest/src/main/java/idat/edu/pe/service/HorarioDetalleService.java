package idat.edu.pe.service;

import idat.edu.pe.model.HorarioDetalle;

public interface HorarioDetalleService{
	
	public abstract void insert(HorarioDetalle horarioDetalle);
	public HorarioDetalle getfindBySeccion(Integer seccionId, Integer trabajadorId);

}
