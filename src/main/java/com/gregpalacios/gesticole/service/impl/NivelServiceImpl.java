package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.Nivel;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.repo.INivelRepo;
import com.gregpalacios.gesticole.service.INivelService;

@Service
public class NivelServiceImpl extends CRUDImpl<Nivel, Integer> implements INivelService {

	@Autowired
	private INivelRepo repo;
	
	@Override
	protected IGenericRepo<Nivel, Integer> getRepo() {
		return repo;
	}

}
