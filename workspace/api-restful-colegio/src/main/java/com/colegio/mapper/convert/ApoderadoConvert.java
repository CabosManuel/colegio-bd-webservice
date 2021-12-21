package com.colegio.mapper.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.colegio.mapper.ApoderadoSimple;
import com.colegio.mapper.ApoderadoMapper;
import com.colegio.model.Apoderado;

public class ApoderadoConvert {

	// Apoderado -> ApoderadoLoginMapper
	public static ApoderadoSimple apoderado_ApoderadoSimple(Apoderado a) {
		return new ApoderadoSimple(a.getDni(),
										a.getNombres(),
										a.getApellidos(),
										a.getCorreo(),
										a.getCelular(),
										a.getDireccion(),
										a.getDistrito());
	}
	
	public static Collection<ApoderadoSimple> collApoderado_CollApoderadoSimple(Collection<Apoderado> apoderados){
		Collection<ApoderadoSimple> apoderadosNuevos = new ArrayList<>();
		for (Apoderado a : apoderados) {
			apoderadosNuevos.add(apoderado_ApoderadoSimple(a));
		}
		
		return apoderadosNuevos;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	// Listar todos los apoderados
	public static Collection<ApoderadoMapper> convertApoderados(Collection<Apoderado> itemsApoderado) {

		Collection<ApoderadoMapper> itemsApoderadoMapper = new ArrayList<>();

		for (Apoderado apoderado : itemsApoderado) {

			ApoderadoMapper mapper = new ApoderadoMapper();
			mapper.setDniApoderado(apoderado.getDni());
			mapper.setNombre(apoderado.getNombres());
			mapper.setApellido(apoderado.getApellidos());
			mapper.setCelular(apoderado.getCelular());
			mapper.setCorreo(apoderado.getCorreo());
			// mapper.setPass(estudiante.getPass());
			mapper.setEstado(apoderado.getEstado());
			mapper.setDireccion(apoderado.getDireccion());
			/*
			 * mapper.setDistrito( new
			 * DistritoMapper(apoderado.getDistrito().getDistritoId(),
			 * apoderado.getDistrito().getNombre()));
			 */

			itemsApoderadoMapper.add(mapper);
		}
		return itemsApoderadoMapper;
	}

	// Listar por dni del apoderado
	public static ApoderadoMapper convert(Apoderado apoderado) {

		ApoderadoMapper mapper = new ApoderadoMapper();
		mapper.setDniApoderado(apoderado.getDni());
		mapper.setNombre(apoderado.getNombres());
		mapper.setApellido(apoderado.getApellidos());
		mapper.setCelular(apoderado.getCelular());
		mapper.setCorreo(apoderado.getCorreo());
		mapper.setPass(apoderado.getPass());
		mapper.setEstado(apoderado.getEstado());
		mapper.setDireccion(apoderado.getDireccion());
		/*
		 * mapper.setDistrito( new
		 * DistritoMapper(apoderado.getDistrito().getDistritoId(),
		 * apoderado.getDistrito().getNombre()));
		 */
		return mapper;

	}

	
	
	// Map Apoderado a ApoderadoLoginMapper
	public static ApoderadoSimple convertMapToApoderadoLogin(Map<String, ?> a) {
		return new ApoderadoSimple(
				a.get("dni_apoderado").toString(), 
				a.get("nombre").toString(),
				a.get("apellido").toString(), 
				a.get("correo").toString(), 
				a.get("celular").toString(),
				a.get("direccion").toString(), 
				a.get("distrito_id").toString());
	}
}
