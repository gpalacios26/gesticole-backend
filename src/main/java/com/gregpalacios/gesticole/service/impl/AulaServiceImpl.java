package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.Aula;
import com.gregpalacios.gesticole.repo.IAulaRepo;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.service.IAulaService;

@Service
public class AulaServiceImpl extends CRUDImpl<Aula, Integer> implements IAulaService {

	@Autowired
	private IAulaRepo repo;
	
	@Override
	protected IGenericRepo<Aula, Integer> getRepo() {
		return repo;
	}

	@Override
	public Page<Aula> listarPageable(Pageable pageable) {
		return repo.listarPaginado(pageable);
	}

}
