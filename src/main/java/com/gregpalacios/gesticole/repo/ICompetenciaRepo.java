package com.gregpalacios.gesticole.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gregpalacios.gesticole.model.Competencia;

public interface ICompetenciaRepo extends IGenericRepo<Competencia, Integer> {

	@Query("SELECT co FROM Competencia co WHERE co.curso.idCurso =:idCurso")
	List<Competencia> listarPorCurso(@Param("idCurso")Integer idCurso);
}
