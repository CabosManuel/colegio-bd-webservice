package com.colegio.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.colegio.model.HorarioCabecera;
import com.colegio.repository.HorarioCabeceraRepository;

@Service
public class HorarioCabeceraServiceImpl implements HorarioCabeceraService{
	
	@Autowired
	private HorarioCabeceraRepository r;

	@Transactional
	@Override
	public void insert(HorarioCabecera horarioCabecera) {
		r.save(horarioCabecera);
	}

	@Transactional
	@Override
	public void update(HorarioCabecera horarioCabecera) {
		r.save(horarioCabecera);
	}

	@Transactional(readOnly = true)
	@Override
	public HorarioCabecera findById(Integer horarioCabeceraId) {
		return r.findById(horarioCabeceraId).orElse(null);
	}
	
	@Transactional(readOnly = true)
	@Override
	public Collection<HorarioCabecera> findAll() {
		return (Collection<HorarioCabecera>)r.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public	Map<String, ?> getfindOneRegister() {
		return r.getfindOneRegister();
	}
	
	

}
