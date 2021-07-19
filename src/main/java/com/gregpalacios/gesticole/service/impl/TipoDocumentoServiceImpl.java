package com.gregpalacios.gesticole.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.TipoDocumento;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.repo.ITipoDocumentoRepo;
import com.gregpalacios.gesticole.service.ITipoDocumentoService;

@Service
public class TipoDocumentoServiceImpl extends CRUDImpl<TipoDocumento, Integer> implements ITipoDocumentoService {

	@Autowired
	private ITipoDocumentoRepo repo;
	
	@Override
	protected IGenericRepo<TipoDocumento, Integer> getRepo() {
		return repo;
	}

}
