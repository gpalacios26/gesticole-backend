package com.gregpalacios.gesticole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gregpalacios.gesticole.dto.CursoCompetenciasDTO;
import com.gregpalacios.gesticole.model.Competencia;
import com.gregpalacios.gesticole.model.Curso;
import com.gregpalacios.gesticole.repo.ICompetenciaRepo;
import com.gregpalacios.gesticole.repo.ICursoRepo;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.service.ICursoService;

@Service
public class CursoServiceImpl extends CRUDImpl<Curso, Integer> implements ICursoService {

	@Autowired
	private ICursoRepo repo;
	
	@Autowired
	private ICompetenciaRepo repoDet;
	
	@Override
	protected IGenericRepo<Curso, Integer> getRepo() {
		return repo;
	}

	@Override
	public Page<Curso> listarPageable(Pageable pageable) {
		return repo.listarPaginado(pageable);
	}

	@Transactional
	@Override
	public Curso registrarTransaccional(CursoCompetenciasDTO dto) throws Exception {
		Curso cabecera = repo.save(dto.getCurso());
		
		for(Competencia detalle: dto.getCompetencias()) {
			detalle.setCurso(cabecera);
			repoDet.save(detalle);
		}
		
		return cabecera;
	}

	@Transactional
	@Override
	public Curso modificarTransaccional(CursoCompetenciasDTO dto) throws Exception {
		List<Competencia> competencias = repoDet.listarPorCurso(dto.getCurso().getIdCurso());
		
		for(Competencia competencia: competencias) {
			repoDet.deleteById(competencia.getIdCompetencia());
		}
		
		Curso cabecera = repo.save(dto.getCurso());
		
		for(Competencia detalle: dto.getCompetencias()) {
			detalle.setCurso(cabecera);
			repoDet.save(detalle);
		}
		
		return cabecera;
	}

	@Transactional
	@Override
	public void eliminarTransaccional(Integer id) throws Exception {
		List<Competencia> competencias = repoDet.listarPorCurso(id);
		
		for(Competencia competencia: competencias) {
			repoDet.deleteById(competencia.getIdCompetencia());
		}
		
		repo.deleteById(id);
	}

}
