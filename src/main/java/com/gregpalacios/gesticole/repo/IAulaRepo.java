package com.gregpalacios.gesticole.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.gregpalacios.gesticole.model.Aula;

public interface IAulaRepo extends IGenericRepo<Aula, Integer> {

	@Query("SELECT a FROM Aula a ORDER BY a.idAula DESC")
	Page<Aula> listarPaginado(Pageable pageable);
}
