package com.gregpalacios.gesticole.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.gregpalacios.gesticole.model.Alumno;

public interface IAlumnoRepo extends IGenericRepo<Alumno, Integer> {

	@Query("SELECT a FROM Alumno a ORDER BY a.idAlumno DESC")
	Page<Alumno> listarPaginado(Pageable pageable);
}
