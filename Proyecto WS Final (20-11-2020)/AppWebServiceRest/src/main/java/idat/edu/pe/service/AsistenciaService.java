package idat.edu.pe.service;

import java.util.Collection;

import idat.edu.pe.mapper.TestMapper;

public interface AsistenciaService {
	public Collection<TestMapper> getAsistenciasByMes(String mes);
}
