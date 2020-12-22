package idat.edu.pe.service;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Apoderado;
import idat.edu.pe.model.Distrito;
import idat.edu.pe.model.Estudiante;
import idat.edu.pe.repository.DistritoRepository;
import idat.edu.pe.repository.EstudianteRepository;
import idat.edu.pe.service.*;

//@Repository
@Service
public class EstudianteServiceImpl implements EstudianteService{

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private EstudianteRepository repository;
	
	/*@Autowired
	private DistritoServiceImpl ServiceD;
	
	@Autowired
	private ApoderadoServiceImpl ServiceA;*/
	
	@Transactional
	@Override
	public void insert(Estudiante estudiante) {
		
		/*try {
			Distrito distrito = new Distrito();
			Apoderado apoderado = new Apoderado(); 
			Collection<Distrito> lista = ServiceD.findAll();
			for(Distrito d : lista) {
				if(d.getDistritoId() == estudiante.getDistrito().getDistritoId()) {
					try {
					//distrito = em.merge(estudiante.getDistrito());
					//apoderado = em.merge(estudiante.getApoderado());
					estudiante.setDistrito(ServiceD.findById(estudiante.getDistrito().getDistritoId()));
					estudiante.setApoderado(ServiceA.findById(estudiante.getApoderado().getApoderadoId()));*/
					repository.save(estudiante);/*
					//em.persist(estudiante);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
				
		}catch (Exception e) {
			 try{
	                System.out.println("Exception:  *****" + e.getMessage());
	            }catch(Exception re){
	                System.out.println("Exception: ^^^^^^" + re.getMessage());
	            }
		}
		//repository.save(estudiante);*/
		
	}

	@Transactional
	@Override
	public void update(Estudiante estudiante) {
		repository.save(estudiante);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Estudiante findByDniEstudiante(String dniEstudiante) {
		return repository.findByDniEstudiante(dniEstudiante);
		
	}

	@Transactional(readOnly = true)
	@Override
	public Collection<Estudiante> findAll() {
		return(Collection<Estudiante>)repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Estudiante findById(String dni_Estudiante) {
		return repository.findById(dni_Estudiante).orElse(null);
	}

}
