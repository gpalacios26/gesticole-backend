package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.Rol;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.repo.IRolRepo;
import com.gregpalacios.gesticole.service.IRolService;

@Service
public class RolServiceImpl extends CRUDImpl<Rol, Integer> implements IRolService {

	@Autowired
	private IRolRepo repo;
	
	@Override
	protected IGenericRepo<Rol, Integer> getRepo() {
		return repo;
	}

}
