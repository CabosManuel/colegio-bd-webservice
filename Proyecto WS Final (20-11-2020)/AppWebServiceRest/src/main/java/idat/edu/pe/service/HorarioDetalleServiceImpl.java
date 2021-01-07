package idat.edu.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.HorarioDetalle;
import idat.edu.pe.repository.HorarioDetalleRepository;

@Service
public class HorarioDetalleServiceImpl implements HorarioDetalleService{
	
	@Autowired
	private HorarioDetalleRepository r;

	@Transactional
	@Override
	public void insert(HorarioDetalle horarioDetalle) {
		r.save(horarioDetalle);
		
	}

	@Transactional(readOnly = true)
	@Override
	public HorarioDetalle getfindBySeccion(Integer seccionId, Integer trabajadorId) {
		return r.getfindBySeccion(seccionId, trabajadorId);
	}
	
	

}