package idat.edu.pe.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.model.Nota;

public class MapperUtil 
{
	public static Collection<EstudianteMapper> convert(Collection<Estudiante> itemsEstudiante){
		
		Collection<EstudianteMapper> itemsEstudianteMapper = new ArrayList<>();
		
		for(Estudiante estudiante: itemsEstudiante) {
			
			EstudianteMapper mapper = new EstudianteMapper();
			mapper.setDniEstudiante(estudiante.getDniEstudiante());
			mapper.setNombre(estudiante.getNombre());
			mapper.setApellido(estudiante.getApellido());
			mapper.setFnacimiento(estudiante.getFnacimiento());
			mapper.setCelular(estudiante.getCelular());
			mapper.setCorreo(estudiante.getCorreo());
			mapper.setDireccion(estudiante.getDireccion());
			//mapper.setPass(estudiante.getPass());
			mapper.setEstado(estudiante.getEstado());
			mapper.setCondicion(estudiante.getCondicion());
			mapper.setDistrito(new DistritoMapper(estudiante.getDistrito().getDistritoId(), estudiante.getDistrito().getNombre()));
			//mapper.setApoderado(new ApoderadoMapper(estudiante.getApoderado().getDniApoderado()));
			
			itemsEstudianteMapper.add(mapper);
		}
		return itemsEstudianteMapper;
	}
	
	public static EstudianteMapper convert(Estudiante estudiante){
	
		EstudianteMapper mapper = new EstudianteMapper();
				mapper.setDniEstudiante(estudiante.getDniEstudiante());
				mapper.setNombre(estudiante.getNombre());
				mapper.setApellido(estudiante.getApellido());
				mapper.setFnacimiento(estudiante.getFnacimiento());
				mapper.setCelular(estudiante.getCelular());
				mapper.setCorreo(estudiante.getCorreo());
				mapper.setDireccion(estudiante.getDireccion());
				mapper.setPass(estudiante.getPass());
				mapper.setEstado(estudiante.getEstado());
				mapper.setCondicion(estudiante.getCondicion());
				mapper.setDistrito(new DistritoMapper(estudiante.getDistrito().getDistritoId(), estudiante.getDistrito().getNombre()));
				mapper.setApoderado(new ApoderadoMapper(estudiante.getApoderado().getDniApoderado()));
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
	
	/**
	 * MAPPERS NOTA
	 */
	
	// Mapper Collection<Object[]> a Collection<NotaMapper>
	public static Collection<NotaMapper> convertCollObjects_NotasMapper(Collection<Object[]> objetos) {
		Collection<NotaMapper> notasMapper = new ArrayList<>();
		
		for(Object[] obj:objetos) {
			notasMapper.add(convertObjectNota(obj));
		}
		
		return notasMapper;
	}
	
	// Mapper Object[] a NotaMapper
	public static NotaMapper convertObjectNota(Object[] obj) {
		NotaMapper notaMapper = new NotaMapper();
		
		notaMapper.setCurso((String) obj[0]);
		notaMapper.setNota1((Integer) obj[1]);
		notaMapper.setNota2((Integer) obj[2]);
		notaMapper.setNota3((Integer) obj[3]);
		
		return notaMapper;
	}
	
	//Listar todos los apoderados
		public static Collection<ApoderadoMapper> convertApoderados(Collection<Apoderado> itemsApoderado){
				
				Collection<ApoderadoMapper> itemsApoderadoMapper = new ArrayList<>();
				
				for(Apoderado apoderado: itemsApoderado) {
					
					ApoderadoMapper mapper = new ApoderadoMapper();
					mapper.setDniApoderado(apoderado.getDniApoderado());
					mapper.setNombre(apoderado.getNombre());
					mapper.setApellido(apoderado.getApellido());
					mapper.setCelular(apoderado.getCelular());
					mapper.setCorreo(apoderado.getCorreo());
					//mapper.setPass(estudiante.getPass());
					mapper.setEstado(apoderado.getEstado());
					mapper.setDistrito(new DistritoMapper(apoderado.getDistrito().getDistritoId(), apoderado.getDistrito().getNombre()));
					
					itemsApoderadoMapper.add(mapper);
				}
				return itemsApoderadoMapper;
		}
		
		//Listar por dni del apoderado
		public static ApoderadoMapper convert(Apoderado apoderado){
			
			ApoderadoMapper mapper = new ApoderadoMapper();
					mapper.setDniApoderado(apoderado.getDniApoderado());
					mapper.setNombre(apoderado.getNombre());
					mapper.setApellido(apoderado.getApellido());
					mapper.setCelular(apoderado.getCelular());
					mapper.setCorreo(apoderado.getCorreo());
					mapper.setPass(apoderado.getPass());
					mapper.setEstado(apoderado.getEstado());
					mapper.setDistrito(new DistritoMapper(apoderado.getDistrito().getDistritoId(), apoderado.getDistrito().getNombre()));
			return mapper;
			
		}
	
}
