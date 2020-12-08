package idat.edu.pe.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.model.Estudiante;

public class MapperUtil 
{
	public static Collection<EstudianteMapper> convert(Collection<Estudiante> itemsEstudiante){
		
		Collection<EstudianteMapper> itemsEstudianteMapper = new ArrayList<>();
		
		for(Estudiante estudiante: itemsEstudiante) {
			
			EstudianteMapper mapper = new EstudianteMapper();
			mapper.setEstudianteId(estudiante.getEstudianteId());
			mapper.setNombre(estudiante.getNombre());
			mapper.setApellido(estudiante.getApellido());
			mapper.setDni(estudiante.getDni());
			mapper.setFnacimiento(estudiante.getFnacimiento());
			mapper.setCelular(estudiante.getCelular());
			mapper.setCorreo(estudiante.getCorreo());
			mapper.setDireccion(estudiante.getDireccion());
			mapper.setPass(estudiante.getPass());
			mapper.setEstado(estudiante.getEstado());
			mapper.setDistrito(new DistritoMapper(estudiante.getDistrito().getDistritoId(), estudiante.getDistrito().getNombre()));
			mapper.setApoderado(new ApoderadoMapper(estudiante.getApoderado().getApoderadoId()));
			
			itemsEstudianteMapper.add(mapper);
		}
		return itemsEstudianteMapper;
	}
	
	public static EstudianteMapper convert(Estudiante estudiante){
	
		EstudianteMapper mapper = new EstudianteMapper();
				mapper.setEstudianteId(estudiante.getEstudianteId());
				mapper.setNombre(estudiante.getNombre());
				mapper.setApellido(estudiante.getApellido());
				mapper.setDni(estudiante.getDni());
				mapper.setFnacimiento(estudiante.getFnacimiento());
				mapper.setCelular(estudiante.getCelular());
				mapper.setCorreo(estudiante.getCorreo());
				mapper.setDireccion(estudiante.getDireccion());
				mapper.setPass(estudiante.getPass());
				mapper.setEstado(estudiante.getEstado());
				mapper.setDistrito(new DistritoMapper(estudiante.getDistrito().getDistritoId(), estudiante.getDistrito().getNombre()));
				mapper.setApoderado(new ApoderadoMapper(estudiante.getApoderado().getApoderadoId()));
		return mapper;
		
	}
	
	public static List<DistritoMapper> convertD(List<Distrito> items){
		List<DistritoMapper> itemsDistritoMapper = new ArrayList<>();
		
		
		for(Distrito distrito: items) {
			DistritoMapper mapper = new DistritoMapper();
			mapper.setDistritoId(distrito.getDistritoId());
			mapper.setNombre(distrito.getNombre());
			
			itemsDistritoMapper.add(mapper);
		}
		
		
		  
		return itemsDistritoMapper;
	}
}
