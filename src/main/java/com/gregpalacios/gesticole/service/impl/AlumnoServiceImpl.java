package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.Alumno;
import com.gregpalacios.gesticole.repo.IAlumnoRepo;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.service.IAlumnoService;

@Service
public class AlumnoServiceImpl extends CRUDImpl<Alumno, Integer> implements IAlumnoService {

	@Autowired
	private IAlumnoRepo repo;
	
	@Override
	protected IGenericRepo<Alumno, Integer> getRepo() {
		return repo;
	}

	@Override
	public Page<Alumno> listarPageable(Pageable pageable) {
		return repo.listarPaginado(pageable);
	}
	
}
