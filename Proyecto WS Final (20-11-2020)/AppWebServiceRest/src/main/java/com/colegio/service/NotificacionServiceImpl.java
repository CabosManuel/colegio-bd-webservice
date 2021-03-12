package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.repository.NotificacionRepository;

@Service
public class NotificacionServiceImpl implements NotificacionService {

	@Autowired
	private NotificacionRepository r;

	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String, Object>> getNotificacionesByDniEstudianteTipo(String dniEstudiante, String tipo1,
			String tipo2, String tipo3) {
		return r.getNotificacionesByDniEstudianteTipo(dniEstudiante, tipo1, tipo2, tipo3);
	}

	@Transactional
	@Override
	public void cambiarEstado(Character estado, Integer notificacionId) {
		r.cambiarEstado(estado, notificacionId);
	}

	@Transactional(readOnly = true)
	@Override
	public Map<String, Object> buscarPorId(Integer notificacionId) {
		return r.buscarPorId(notificacionId);
	}
}
