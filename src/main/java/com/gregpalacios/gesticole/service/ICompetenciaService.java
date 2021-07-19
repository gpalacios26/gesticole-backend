package com.gregpalacios.gesticole.service;

import java.util.List;

import com.gregpalacios.gesticole.model.Competencia;

public interface ICompetenciaService extends ICRUD<Competencia, Integer> {

	List<Competencia> listarPorCurso(Integer idCurso);
}
