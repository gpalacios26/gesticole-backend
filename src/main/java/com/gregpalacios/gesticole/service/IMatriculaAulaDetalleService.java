package com.gregpalacios.gesticole.service;

import java.util.List;

import com.gregpalacios.gesticole.model.MatriculaAulaDetalle;

public interface IMatriculaAulaDetalleService extends ICRUD<MatriculaAulaDetalle, Integer> {

	List<MatriculaAulaDetalle> listarPorMatricula(Integer idMatricula);
}
