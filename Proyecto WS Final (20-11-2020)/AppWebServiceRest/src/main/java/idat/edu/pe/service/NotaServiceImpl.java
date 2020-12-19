package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.mapper.NotaMapper;
import idat.edu.pe.repository.NotaRepository;

@Service
public class NotaServiceImpl implements NotaService{

	@Autowired
	private NotaRepository r;
	
	@Override
	@Transactional(readOnly = true)
	public Collection</*NotaMapper*/Object[]> findByDniEstudianteAnio(String dniEstudiante, String anio) {
		//Collection<Object[]> obj = r.findByDniEstudianteAnio(dniEstudiante, anio);
		
		
		
		return r.findByDniEstudianteAnio(dniEstudiante, anio);
	}

}
