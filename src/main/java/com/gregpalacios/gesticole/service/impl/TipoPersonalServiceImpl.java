package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.TipoPersonal;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.repo.ITipoPersonalRepo;
import com.gregpalacios.gesticole.service.ITipoPersonalService;

@Service
public class TipoPersonalServiceImpl extends CRUDImpl<TipoPersonal, Integer> implements ITipoPersonalService {

	@Autowired
	private ITipoPersonalRepo repo;
	
	@Override
	protected IGenericRepo<TipoPersonal, Integer> getRepo() {
		return repo;
	}

}
