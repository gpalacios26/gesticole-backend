package com.gregpalacios.gesticole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.MatriculaAulaDetalle;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.repo.IMatriculaAulaDetalleRepo;
import com.gregpalacios.gesticole.service.IMatriculaAulaDetalleService;

@Service
public class MatriculaAulaDetalleServiceImpl extends CRUDImpl<MatriculaAulaDetalle, Integer>
		implements IMatriculaAulaDetalleService {

	@Autowired
	private IMatriculaAulaDetalleRepo repo;

	@Override
	protected IGenericRepo<MatriculaAulaDetalle, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<MatriculaAulaDetalle> listarPorMatricula(Integer idMatricula) {
		return repo.listarPorMatricula(idMatricula);
	}

}
