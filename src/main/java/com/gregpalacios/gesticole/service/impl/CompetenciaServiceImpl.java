package com.gregpalacios.gesticole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.Competencia;
import com.gregpalacios.gesticole.repo.ICompetenciaRepo;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.service.ICompetenciaService;

@Service
public class CompetenciaServiceImpl extends CRUDImpl<Competencia, Integer> implements ICompetenciaService {

	@Autowired
	private ICompetenciaRepo repo;
	
	@Override
	protected IGenericRepo<Competencia, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<Competencia> listarPorCurso(Integer idCurso) {
		return repo.listarPorCurso(idCurso);
	}

}
