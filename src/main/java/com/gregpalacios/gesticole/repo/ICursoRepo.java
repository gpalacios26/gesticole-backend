package com.gregpalacios.gesticole.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.gregpalacios.gesticole.model.Curso;

public interface ICursoRepo extends IGenericRepo<Curso, Integer> {

	@Query("SELECT c FROM Curso c ORDER BY c.idCurso DESC")
	Page<Curso> listarPaginado(Pageable pageable);
}
