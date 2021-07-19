package com.gregpalacios.gesticole.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gregpalacios.gesticole.model.MatriculaAulaDetalle;

public interface IMatriculaAulaDetalleRepo extends IGenericRepo<MatriculaAulaDetalle, Integer> {

	@Query("SELECT md FROM MatriculaAulaDetalle md WHERE md.matricula.idMatricula =:idMatricula")
	List<MatriculaAulaDetalle> listarPorMatricula(@Param("idMatricula")Integer idMatricula);
}
