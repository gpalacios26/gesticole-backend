package com.gregpalacios.gesticole.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gregpalacios.gesticole.dto.CursoCompetenciasDTO;
import com.gregpalacios.gesticole.model.Curso;

public interface ICursoService extends ICRUD<Curso, Integer> {

	Page<Curso> listarPageable(Pageable pageable);
	
	Curso registrarTransaccional(CursoCompetenciasDTO dto) throws Exception;
	
	Curso modificarTransaccional(CursoCompetenciasDTO dto) throws Exception;
	
	void eliminarTransaccional(Integer id) throws Exception;
}
