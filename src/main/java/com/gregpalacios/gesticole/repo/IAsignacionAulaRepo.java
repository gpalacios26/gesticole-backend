package com.gregpalacios.gesticole.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.gregpalacios.gesticole.model.AsignacionAula;

public interface IAsignacionAulaRepo extends IGenericRepo<AsignacionAula, Integer> {

	@Query("SELECT a FROM AsignacionAula a ORDER BY a.idAsignacion DESC")
	Page<AsignacionAula> listarPaginado(Pageable pageable);
}
