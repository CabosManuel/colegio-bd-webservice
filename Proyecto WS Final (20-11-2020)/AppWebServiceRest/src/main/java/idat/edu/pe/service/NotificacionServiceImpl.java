package idat.edu.pe.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Notificacion;
import idat.edu.pe.repository.NotificacionRepository;

@Service
public class NotificacionServiceImpl implements NotificacionService{

	@Autowired
	private NotificacionRepository r;
	
	@Transactional(readOnly = true)
	@Override
	public Collection<Object[]> getNotificacionesByDniEstudianteTipo(String dniEstudiante, String tipo1,
			String tipo2, String tipo3) {
		return r.getNotificacionesByDniEstudianteTipo(dniEstudiante, tipo1, tipo2, tipo3);
	}
	
	
}
