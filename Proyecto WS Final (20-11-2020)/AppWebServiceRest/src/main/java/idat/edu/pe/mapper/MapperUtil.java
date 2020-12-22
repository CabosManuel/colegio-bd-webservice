package idat.edu.pe.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.model.Grado;
import idat.edu.pe.model.Matricula;
import idat.edu.pe.model.Nivel;
import idat.edu.pe.model.Nota;
import idat.edu.pe.model.Seccion;
import idat.edu.pe.service.GradoService;

public class MapperUtil 
{
	
	@Autowired
	private GradoService gservice; 
	
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
			mapper.setApoderado(new ApoderadoMapper(estudiante.getApoderado().getDniApoderado()));
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
	
	public static Collection<NotaMapper> convertNotas(Collection<Nota> itemsNota){
		
		Collection<NotaMapper> itemsNotaMapper = new ArrayList<>();
		
		for(Nota nota: itemsNota) {
				NotaMapper mapper = new NotaMapper();
				//mapper.setNota_id(nota.getNotaId());
				mapper.setDni_estudiante(new EstudianteMapper(nota.getDniEstudiante().getDniEstudiante()));
				mapper.setCursom(new CursoMapper(nota.getCurso().getCursoId(), nota.getCurso().getNombre()));
				mapper.setNota1(nota.getNota1());
				mapper.setNota2(nota.getNota2());
				mapper.setNota3(nota.getNota3());
				mapper.setFecha(nota.getFecha());
				//n.nota_id, c.curso_id, e.dni_estudiante, n.fecha,
				itemsNotaMapper.add(mapper);
		}
		return itemsNotaMapper;
		
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
		//notaMapper.setFecha((String) obj[4]);
		
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
		
		//MATRICULA
		public static MatriculaMapper convert(Matricula matricula){
			
			MatriculaMapper mapper = new MatriculaMapper();
			//Collection<Grado> grados = gservice.findByNivel(matricula.getNivel());
			//Nivel n = new Nivel();
			Grado g = new Grado();
			
					mapper.setEstudiante(new EstudianteMapper(matricula.getEstudiante().getDniEstudiante()));
					mapper.setFecha(matricula.getFecha());
					mapper.setNivel(matricula.getNivel());
					//mapper.setNombrenivel(matricula.get);
					
					//for(Grado grado: grados) {
						//if(g.getGradoId() == matricula.getGrado()) {
							mapper.setGrado(matricula.getGrado());
							//mapper.setNombregrado(g.getNombre());
						//}
					//}
					mapper.setSeccion(new SeccionMapper(matricula.getSeccion().getSeccionId(), matricula.getSeccion().getNombre()));
			return mapper;
		}
		
		//SECCION
		public static Collection<SeccionMapper> convertSeccion(Collection<Seccion> itemsSeccion){
			
			Collection<SeccionMapper> itemsSeccionMapper = new ArrayList<>();
			
			for(Seccion seccion: itemsSeccion) {
				
				SeccionMapper mapper = new SeccionMapper();
				mapper.setSeccion_id(seccion.getSeccionId());
				mapper.setNombre(seccion.getNombre());
				itemsSeccionMapper.add(mapper);
			}
			return itemsSeccionMapper;
		}
	
}
