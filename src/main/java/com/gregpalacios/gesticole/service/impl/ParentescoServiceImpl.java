package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.Parentesco;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.repo.IParentescoRepo;
import com.gregpalacios.gesticole.service.IParentescoService;

@Service
public class ParentescoServiceImpl extends CRUDImpl<Parentesco, Integer> implements IParentescoService {

	@Autowired
	private IParentescoRepo repo;
	
	@Override
	protected IGenericRepo<Parentesco, Integer> getRepo() {
		return repo;
	}

}
