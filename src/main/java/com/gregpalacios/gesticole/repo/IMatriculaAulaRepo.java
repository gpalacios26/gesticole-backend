package com.gregpalacios.gesticole.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.gregpalacios.gesticole.model.MatriculaAula;

public interface IMatriculaAulaRepo extends IGenericRepo<MatriculaAula, Integer> {

	@Query("SELECT m FROM MatriculaAula m ORDER BY m.idMatricula DESC")
	Page<MatriculaAula> listarPaginado(Pageable pageable);
}
