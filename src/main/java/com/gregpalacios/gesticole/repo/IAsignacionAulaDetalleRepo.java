package com.gregpalacios.gesticole.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gregpalacios.gesticole.model.AsignacionAulaDetalle;

public interface IAsignacionAulaDetalleRepo extends IGenericRepo<AsignacionAulaDetalle, Integer> {

	@Query("SELECT ad FROM AsignacionAulaDetalle ad WHERE ad.asignacion.idAsignacion =:idAsignacion")
	List<AsignacionAulaDetalle> listarPorAsignacion(@Param("idAsignacion")Integer idAsignacion);
}
