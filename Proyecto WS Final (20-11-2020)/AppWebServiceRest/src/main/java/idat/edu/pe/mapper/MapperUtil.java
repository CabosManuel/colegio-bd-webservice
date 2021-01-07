package idat.edu.pe.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Curso;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.model.Grado;
import idat.edu.pe.model.HorarioCabecera;
import idat.edu.pe.model.HorarioDetalle;
import idat.edu.pe.model.Matricula;
import idat.edu.pe.model.Nivel;
import idat.edu.pe.model.Nota;
import idat.edu.pe.model.Seccion;
import idat.edu.pe.model.Trabajador;
import idat.edu.pe.service.GradoService;

public class MapperUtil {

	@Autowired
	private GradoService gservice;

	public static Collection<EstudianteMapper> convert(Collection<Estudiante> itemsEstudiante) {

		Collection<EstudianteMapper> itemsEstudianteMapper = new ArrayList<>();

		for (Estudiante estudiante : itemsEstudiante) {

			EstudianteMapper mapper = new EstudianteMapper();
			mapper.setDniEstudiante(estudiante.getDniEstudiante());
			mapper.setNombre(estudiante.getNombre());
			mapper.setApellido(estudiante.getApellido());
			mapper.setFnacimiento(estudiante.getFnacimiento());
			mapper.setCelular(estudiante.getCelular());
			mapper.setCorreo(estudiante.getCorreo());
			mapper.setDireccion(estudiante.getDireccion());
			// mapper.setPass(estudiante.getPass());
			mapper.setEstado(estudiante.getEstado());
			mapper.setCondicion(estudiante.getCondicion());
			mapper.setDistrito(
					new DistritoMapper(estudiante.getDistrito().getDistritoId(), estudiante.getDistrito().getNombre()));
			mapper.setApoderado(new ApoderadoMapper(estudiante.getApoderado().getDniApoderado()));
			itemsEstudianteMapper.add(mapper);
		}
		return itemsEstudianteMapper;
	}

	public static EstudianteMapper convert(Estudiante estudiante) {

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
		mapper.setDistrito(
				new DistritoMapper(estudiante.getDistrito().getDistritoId(), estudiante.getDistrito().getNombre()));
		mapper.setApoderado(new ApoderadoMapper(estudiante.getApoderado().getDniApoderado()));
		return mapper;

	}
	
	// Estudiante a EstudianteRespuestaMapper (sin "rpta" y "mensaje")
	public static EstudianteRespuestaMapper convertEstudianteToRespuesta(Estudiante estudiante) {
		EstudianteMapper estudianteMapper = convert(estudiante);
		
		EstudianteRespuestaMapper estudianteRespuestaMapper = new EstudianteRespuestaMapper();
		estudianteRespuestaMapper.setEstudiante(estudianteMapper);
		
		return estudianteRespuestaMapper;
	}

	// Mapper Collection<Object[]> a Collection<EstudianteMapper>
	public static Collection<EstudianteMapper> convertCollObjects_EstudianteMapper(Collection<Object[]> objetos) {
		Collection<EstudianteMapper> estudiantesMapper = new ArrayList<>();

		for (Object[] obj : objetos) {
			estudiantesMapper.add(convertObjectEstudiante(obj));
		}

		return estudiantesMapper;
	}

	// Mapper Object[] a EstudianteMapper
	public static EstudianteMapper convertObjectEstudiante(Object[] obj) {
		EstudianteMapper estudianteMapper = new EstudianteMapper();

		estudianteMapper.setDniEstudiante((String) obj[0]);
		estudianteMapper.setNombre((String) obj[1]);

		return estudianteMapper;
	}

	public static Collection<NotaMapper> convertNotas(Collection<Nota> itemsNota) {

		Collection<NotaMapper> itemsNotaMapper = new ArrayList<>();

		for (Nota nota : itemsNota) {
			NotaMapper mapper = new NotaMapper();
			// mapper.setNota_id(nota.getNotaId());
			mapper.setDni_estudiante(new EstudianteMapper(nota.getDniEstudiante().getDniEstudiante()));
			mapper.setCursom(new CursoMapper(nota.getCurso().getCursoId(), nota.getCurso().getNombre()));
			mapper.setNota1(nota.getNota1());
			mapper.setNota2(nota.getNota2());
			mapper.setNota3(nota.getNota3());
			mapper.setFecha(nota.getFecha());
			// n.nota_id, c.curso_id, e.dni_estudiante, n.fecha,
			itemsNotaMapper.add(mapper);
		}
		return itemsNotaMapper;

	}

	public static List<DistritoMapper> convertD(List<Distrito> items) {
		List<DistritoMapper> itemsDistritoMapper = new ArrayList<>();

		for (Distrito distrito : items) {
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

		for (Object[] obj : objetos) {
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
		// notaMapper.setFecha((String) obj[4]);

		return notaMapper;
	}

	/**
	 * MAPPERS APODERADO
	 */
	
	// Listar todos los apoderados
	public static Collection<ApoderadoMapper> convertApoderados(Collection<Apoderado> itemsApoderado) {

		Collection<ApoderadoMapper> itemsApoderadoMapper = new ArrayList<>();

		for (Apoderado apoderado : itemsApoderado) {

			ApoderadoMapper mapper = new ApoderadoMapper();
			mapper.setDniApoderado(apoderado.getDniApoderado());
			mapper.setNombre(apoderado.getNombre());
			mapper.setApellido(apoderado.getApellido());
			mapper.setCelular(apoderado.getCelular());
			mapper.setCorreo(apoderado.getCorreo());
			// mapper.setPass(estudiante.getPass());
			mapper.setEstado(apoderado.getEstado());
			mapper.setDireccion(apoderado.getDireccion());
			mapper.setDistrito(
					new DistritoMapper(apoderado.getDistrito().getDistritoId(), apoderado.getDistrito().getNombre()));

			itemsApoderadoMapper.add(mapper);
		}
		return itemsApoderadoMapper;
	}

	// Listar por dni del apoderado
	public static ApoderadoMapper convert(Apoderado apoderado) {

		ApoderadoMapper mapper = new ApoderadoMapper();
		mapper.setDniApoderado(apoderado.getDniApoderado());
		mapper.setNombre(apoderado.getNombre());
		mapper.setApellido(apoderado.getApellido());
		mapper.setCelular(apoderado.getCelular());
		mapper.setCorreo(apoderado.getCorreo());
		//mapper.setPass(apoderado.getPass());
		mapper.setEstado(apoderado.getEstado());
		mapper.setDireccion(apoderado.getDireccion());
		mapper.setDistrito(
				new DistritoMapper(apoderado.getDistrito().getDistritoId(), apoderado.getDistrito().getNombre()));
		return mapper;

	}
	
	// Apoderado a ApoderadoRespuestaMapper (sin "rpta" y "mensaje") 
	public static ApoderadoRespuestaMapper convertApoderadoToRespuesta(Apoderado apoderado) {
		ApoderadoMapper apoderadoMapper = convert(apoderado);
		
		ApoderadoRespuestaMapper apoderadoRespuestaMapper = new ApoderadoRespuestaMapper();
		apoderadoRespuestaMapper.setApoderado(apoderadoMapper);
		
		return apoderadoRespuestaMapper;
	}

	// MATRICULA
	public static MatriculaMapper convert(Matricula matricula) {

		MatriculaMapper mapper = new MatriculaMapper();
		mapper.setEstudiante(new EstudianteMapper(matricula.getEstudiante().getDniEstudiante()));
		mapper.setFecha(matricula.getFecha());
		mapper.setNivel(matricula.getNivel());
		mapper.setGrado(matricula.getGrado());
		mapper.setSeccion(new SeccionMapper(matricula.getSeccion().getSeccionId(), matricula.getSeccion().getNombre()));
		return mapper;
	}

	// SECCION
	public static Collection<SeccionMapper> convertSeccion(Collection<Seccion> itemsSeccion) {

		Collection<SeccionMapper> itemsSeccionMapper = new ArrayList<>();

		for (Seccion seccion : itemsSeccion) {

			SeccionMapper mapper = new SeccionMapper();
			mapper.setSeccionId(seccion.getSeccionId());
			mapper.setNombre(seccion.getNombre());
			itemsSeccionMapper.add(mapper);
		}
		return itemsSeccionMapper;
	}

	/**
	 * MAPPERS CURSO
	 */

	// Mapper Collection<Object[]> a Collection<CursoMapper>
	public static Collection<CursoMapper> convertCollObjects_CursoMapper(Collection<Object[]> objetos) {
		Collection<CursoMapper> cursosMapper = new ArrayList<>();

		for (Object[] obj : objetos) {
			cursosMapper.add(convertObjectCurso(obj));
		}

		return cursosMapper;
	}

	// Mapper Object[] a CursoMapper
	public static CursoMapper convertObjectCurso(Object[] obj) {
		CursoMapper cursoMapper = new CursoMapper();

		cursoMapper.setCurso_id((Integer) obj[0]);
		cursoMapper.setNombre((String) obj[1]);

		return cursoMapper;
	}

	public static Collection<TrabajadorMapper> convertTrabajadores(Collection<Trabajador> itemsTrabajador) {

		Collection<TrabajadorMapper> itemsTrabajadorMapper = new ArrayList<>();

		for (Trabajador trabajador : itemsTrabajador) {

			TrabajadorMapper mapper = new TrabajadorMapper();
			mapper.setTrabajadorId(trabajador.getTrabajadorId());
			mapper.setNombres(trabajador.getNombres());
			mapper.setApellidos(trabajador.getApellidos());
			mapper.setCargo(trabajador.getCargo());
			mapper.setFechaNacimiento(trabajador.getFechaNacimiento());
			mapper.setDni(trabajador.getDni());
			mapper.setCelular(trabajador.getCelular());
			mapper.setCorreo(trabajador.getCorreo());
			mapper.setDireccion(trabajador.getDireccion());
			mapper.setEstado(trabajador.getEstado());
			//mapper.setPass(trabajador.getPass());
			mapper.setDistrito(
					new DistritoMapper(trabajador.getDistrito().getDistritoId(), trabajador.getDistrito().getNombre()));
			itemsTrabajadorMapper.add(mapper);
		}
		return itemsTrabajadorMapper;
	}

	public static Collection<TrabajadorMapper> convertTrabajadoresPorCurso(Collection<Trabajador> itemsTrabajador) {

		Collection<TrabajadorMapper> itemsTrabajadorMapper = new ArrayList<>();

		for (Trabajador trabajador : itemsTrabajador) {

			TrabajadorMapper mapper = new TrabajadorMapper();
			mapper.setTrabajadorId(trabajador.getTrabajadorId());
			mapper.setNombres(trabajador.getNombres());
			mapper.setApellidos(trabajador.getApellidos());
			itemsTrabajadorMapper.add(mapper);
		}
		return itemsTrabajadorMapper;
	}

	public static Collection<SeccionMapper> convertSecciones(Collection<Seccion> itemsSeccion) {

		Collection<SeccionMapper> itemsSeccionMapper = new ArrayList<>();

		for (Seccion seccion : itemsSeccion) {

			SeccionMapper mapper = new SeccionMapper();
			mapper.setSeccionId(seccion.getSeccionId());
			mapper.setNombre(seccion.getNombre());
			mapper.setGrado(new GradoMapper(seccion.getGrado().getGradoId(), seccion.getGrado().getNombre(),
					new NivelMapper(seccion.getGrado().getNivel().getNivelId())));
			itemsSeccionMapper.add(mapper);
		}
		return itemsSeccionMapper;
	}

	/**
	 * MAPPERS ASISTENCIA
	 */

	// Mapper Collection<Object[]> a Collection<AsistenciaMapper>
	public static Collection<AsistenciaMapper> convertCollObjects_AsistenciaMapper(Collection<Object[]> objetos) {
		Collection<AsistenciaMapper> asistenciaMapper = new ArrayList<>();

		for (Object[] obj : objetos) {
			asistenciaMapper.add(convertObjectAsistencia(obj));
		}

		return asistenciaMapper;
	}

	// Mapper Object[] a AsistenciaMapper
	public static AsistenciaMapper convertObjectAsistencia(Object[] obj) {
		AsistenciaMapper asistenciaMapper = new AsistenciaMapper();

		asistenciaMapper.setEstado((Boolean) obj[0]);
		LocalDate fehcaAumentada = LocalDate.parse(obj[1].toString());
		asistenciaMapper.setFecha(fehcaAumentada.plusDays(1));

		return asistenciaMapper;
	}

	// Listar Curso por Nivel y Grado
	public static Collection<CursoMapper> convertCursosPorNivelGrado(Collection<Curso> itemsCurso) {

		Collection<CursoMapper> itemsCursoMapper = new ArrayList<>();

		for (Curso curso : itemsCurso) {

			CursoMapper mapper = new CursoMapper();
			mapper.setCurso_id(curso.getCursoId());
			mapper.setNombre(curso.getNombre());
			itemsCursoMapper.add(mapper);
		}
		return itemsCursoMapper;
	}

	/**
	 * MAPPER NOTIFICACIONES
	 */
	public static Collection<NotificacionMapper> convertCollObjects_NotificacionMapper(Collection<Object[]> objetos) {
		Collection<NotificacionMapper> notificacionesMapper = new ArrayList<>();

		for (Object[] obj : objetos) {
			NotificacionMapper notfMapp = new NotificacionMapper();

			notfMapp.setIdNofiticacion((Integer) obj[0]);
			notfMapp.setTitulo(obj[1].toString());
			notfMapp.setTipo(obj[2].toString());
			notfMapp.setFechaEnvio(obj[3].toString());
			notfMapp.setDniEstudiante(obj[6].toString());
			notfMapp.setDescripcion(obj[7].toString());

			if (!notfMapp.getTipo().equals("comunicado")) {
				notfMapp.setFechaLimite(obj[4].toString());
				notfMapp.setEstado((Character) obj[5]);
			}

			notificacionesMapper.add(notfMapp);
		}

		return notificacionesMapper;
	}
	
	/**
	 * MAPPER JUSTIFICACIONES
	 */
	public static Collection<JustificacionMapper> convertCollObjects_JustificacionMapper(Collection<Object[]> objetos) {
		Collection<JustificacionMapper> justificacionesMapper = new ArrayList<>();

		for (Object[] obj : objetos) {
			JustificacionMapper jstfMapp = new JustificacionMapper();

			jstfMapp.setJustificacionId((Integer) obj[0]);
			jstfMapp.setTitulo(obj[1].toString());
			jstfMapp.setFechaEnvio(obj[2].toString());
			jstfMapp.setFechaJustificacion(obj[3].toString());
			jstfMapp.setDniEstudiante(obj[4].toString());
			jstfMapp.setDescripcion(obj[5].toString());

			justificacionesMapper.add(jstfMapp);
		}

		return justificacionesMapper;
	}

	public static SeccionMapper convertOneSeccion(Seccion seccion) {

		SeccionMapper mapper = new SeccionMapper();
		mapper.setSeccionId(seccion.getSeccionId());
		mapper.setNombre(seccion.getNombre());

		return mapper;
	}

	/**
	 * GRADO
	 */
	public static GradoMapper convertOneGrado(Grado grado) {

		GradoMapper mapper = new GradoMapper();
		mapper.setGrado_id(grado.getGradoId());
		mapper.setNombre(grado.getNombre());

		return mapper;
	}

	/**
	 * NIVEL
	 */
	public static NivelMapper convertOneNivel(Nivel nivel) {

		NivelMapper mapper = new NivelMapper();
		mapper.setNivel_id(nivel.getNivelId());
		mapper.setNombre(nivel.getNombre());

		return mapper;
	}

//HORARIO CABECERA
	public static HorarioCabeceraMapper convertHorarioCabeceraId(HorarioCabecera horarioCabecera) {

		HorarioCabeceraMapper mapper = new HorarioCabeceraMapper();
		HorarioDetalleMapper mapperDetalle = new HorarioDetalleMapper();

		mapper.setEstado(horarioCabecera.getEstado());
		mapper.setSeccion(new SeccionMapper(horarioCabecera.getSeccion().getSeccionId()));
		mapper.setTrabajador(new TrabajadorMapper(horarioCabecera.getTrabajador().getTrabajadorId()));
		mapperDetalle.setHorarioCabecera(new HorarioCabeceraMapper(horarioCabecera.getHorarioCabeceraId()));
		return mapper;

	}


	/*
	 * CAMBIOS A LA FECHA 03/01/2021*/
	public static HorarioDetalleMapper convert(HorarioDetalle horariod) {

		HorarioDetalleMapper mapper = new HorarioDetalleMapper();
		mapper.setHorarioDetalleId(horariod.getHorarioDetalleId());
		mapper.setDia(horariod.getDia());
		mapper.setCurso(new CursoMapper(horariod.getCurso().getCursoId(), horariod.getCurso().getNombre()));
		mapper.setTrabajador(new TrabajadorMapper(horariod.getTrabajador().getTrabajadorId()));
		mapper.setHoraInicio(horariod.getHoraInicio());
		mapper.setHoraFin(horariod.getHoraFin());
		mapper.setHorarioCabecera(new HorarioCabeceraMapper(horariod.getHorarioCabecera().getHorarioCabeceraId()));
		return mapper;

	}
	
	public static Collection<GradoMapper> convertGrados(Collection<Grado> itemsGrado) {

		Collection<GradoMapper> itemsGradoMapper = new ArrayList<>();

		for (Grado grado : itemsGrado) {

			GradoMapper mapper = new GradoMapper();
			mapper.setGrado_id(grado.getGradoId());
			mapper.setNombre(grado.getNombre());
			itemsGradoMapper.add(mapper);
		}
		return itemsGradoMapper;
	}

	/**
	 * NIVEL
	 */

	public static Collection<NivelMapper> convertNiveles(Collection<Nivel> itemsNivel) {

		Collection<NivelMapper> itemsNivelMapper = new ArrayList<>();

		for (Nivel nivel : itemsNivel) {

			NivelMapper mapper = new NivelMapper();
			mapper.setNivel_id(nivel.getNivelId());
			mapper.setNombre(nivel.getNombre());
			itemsNivelMapper.add(mapper);
		}
		return itemsNivelMapper;
	}


}
