package com.gregpalacios.gesticole.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.gregpalacios.gesticole.model.Personal;

public interface IPersonalRepo extends IGenericRepo<Personal, Integer> {

	@Query("SELECT p FROM Personal p ORDER BY p.idPersonal DESC")
	Page<Personal> listarPaginado(Pageable pageable);
}
