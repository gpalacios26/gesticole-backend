package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.Personal;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.repo.IPersonalRepo;
import com.gregpalacios.gesticole.service.IPersonalService;

@Service
public class PersonalServiceImpl extends CRUDImpl<Personal, Integer> implements IPersonalService {

	@Autowired
	private IPersonalRepo repo;
	
	@Override
	protected IGenericRepo<Personal, Integer> getRepo() {
		return repo;
	}

	@Override
	public Page<Personal> listarPageable(Pageable pageable) {
		return repo.listarPaginado(pageable);
	}

}
