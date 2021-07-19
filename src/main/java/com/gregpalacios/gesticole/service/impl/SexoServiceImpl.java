package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.Sexo;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.repo.ISexoRepo;
import com.gregpalacios.gesticole.service.ISexoService;

@Service
public class SexoServiceImpl extends CRUDImpl<Sexo, Integer> implements ISexoService {

	@Autowired
	private ISexoRepo repo;
	
	@Override
	protected IGenericRepo<Sexo, Integer> getRepo() {
		return repo;
	}

}
