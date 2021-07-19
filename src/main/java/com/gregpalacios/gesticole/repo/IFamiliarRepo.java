package com.gregpalacios.gesticole.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.gregpalacios.gesticole.model.Familiar;

public interface IFamiliarRepo extends IGenericRepo<Familiar, Integer> {

	@Query("SELECT f FROM Familiar f ORDER BY f.idFamiliar DESC")
	Page<Familiar> listarPaginado(Pageable pageable);
}
