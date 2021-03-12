package com.colegio.service;

import java.util.Collection;
import java.util.Map;

public interface NotificacionService {
	Collection<Map<String, Object>> getNotificacionesByDniEstudianteTipo(String dniEstudiante, String tipo1, String tipo2, String tipo3);
	void cambiarEstado(Character estado, Integer notificacionId);
	Map<String, Object> buscarPorId(Integer notificacionId);
}
