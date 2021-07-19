package com.gregpalacios.gesticole.service;

import java.util.List;

import com.gregpalacios.gesticole.model.AsignacionAulaDetalle;

public interface IAsignacionAulaDetalleService extends ICRUD<AsignacionAulaDetalle, Integer> {

	List<AsignacionAulaDetalle> listarPorAsignacion(Integer idAsignacion);
}
