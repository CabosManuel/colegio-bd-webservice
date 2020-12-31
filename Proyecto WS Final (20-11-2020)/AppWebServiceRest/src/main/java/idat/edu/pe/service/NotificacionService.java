package idat.edu.pe.service;

import java.util.Collection;

public interface NotificacionService {
	public Collection<Object[]> getNotificacionesByDniEstudianteTipo(String dniEstudiante, String tipo1, String tipo2, String tipo3);
}
