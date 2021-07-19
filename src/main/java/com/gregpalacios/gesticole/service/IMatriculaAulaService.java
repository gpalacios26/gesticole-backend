package com.gregpalacios.gesticole.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gregpalacios.gesticole.dto.MatriculaAulaDTO;
import com.gregpalacios.gesticole.model.MatriculaAula;

public interface IMatriculaAulaService extends ICRUD<MatriculaAula, Integer> {

	Page<MatriculaAula> listarPageable(Pageable pageable);

	MatriculaAula registrarTransaccional(MatriculaAulaDTO dto) throws Exception;

	MatriculaAula modificarTransaccional(MatriculaAulaDTO dto) throws Exception;

	void eliminarTransaccional(Integer id) throws Exception;
}
