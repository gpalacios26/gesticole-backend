package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.Dia;
import com.gregpalacios.gesticole.repo.IDiaRepo;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.service.IDiaService;

@Service
public class DiaServiceImpl extends CRUDImpl<Dia, Integer> implements IDiaService {

	@Autowired
	private IDiaRepo repo;
	
	@Override
	protected IGenericRepo<Dia, Integer> getRepo() {
		return repo;
	}

}
