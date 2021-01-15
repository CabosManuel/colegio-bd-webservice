package idat.edu.pe.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.edu.pe.model.Distrito;
import idat.edu.pe.repository.DistritoRepository;

@Service
public class DistritoServiceImpl implements DistritoService{
	
	@Autowired
	private DistritoRepository repository;

	@Transactional
	@Override
	public void insert(Distrito distrito) {
		repository.save(distrito);
	}

	@Transactional
	@Override
	public void update(Distrito distrito) {
		repository.save(distrito);
	}

	@Transactional
	@Override
	public void delete(Integer distritoId) {
		repository.deleteById(distritoId);	
	}

	@Transactional(readOnly = true)
	@Override
	public Distrito findById(Integer distritoId) {
		return repository.findById(distritoId).orElse(null);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Distrito> findAll() {
		return (List<Distrito>)repository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Collection<Map<String,?>> all(){
		return repository.all();
	}
}
