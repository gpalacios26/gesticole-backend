package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.Anio;
import com.gregpalacios.gesticole.repo.IAnioRepo;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.service.IAnioService;

@Service
public class AnioServiceImpl extends CRUDImpl<Anio, Integer> implements IAnioService {

	@Autowired
	private IAnioRepo repo;
	
	@Override
	protected IGenericRepo<Anio, Integer> getRepo() {
		return repo;
	}

}
