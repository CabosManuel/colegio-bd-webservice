package idat.edu.pe.service;

import java.util.Collection;
import java.util.Map;

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
	public Collection<Map<String, ?>> getfindBySeccion(Integer seccionId, Integer trabajadorId) {
		return r.getfindBySeccion(seccionId, trabajadorId);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> findHorarioByDni(String dniEstudiante){
		return r.findHorarioByDni(dniEstudiante);
	}

	@Transactional(readOnly = true)
	@Override
	public HorarioDetalle findById(Integer horarioDetalleId) {
		return r.findById(horarioDetalleId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, ?>> buscarHorarioPorSeccion(Integer seccionId) {
		return r.buscarHorarioPorSeccion(seccionId);
	}
	
	@Transactional
	@Override
	public void update(HorarioDetalle horarioDetalle) {
		r.save(horarioDetalle);
	}

}
