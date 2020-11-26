package idat.edu.pe.mapper;

import java.util.ArrayList;
import java.util.Collection;

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
		return mapper;
		
	}

}
