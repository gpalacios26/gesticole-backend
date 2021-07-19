package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.Familiar;
import com.gregpalacios.gesticole.repo.IFamiliarRepo;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.service.IFamiliarService;

@Service
public class FamiliarServiceImpl extends CRUDImpl<Familiar, Integer> implements IFamiliarService {

	@Autowired
	private IFamiliarRepo repo;
	
	@Override
	protected IGenericRepo<Familiar, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public Page<Familiar> listarPageable(Pageable pageable) {
		return repo.listarPaginado(pageable);
	}

}
