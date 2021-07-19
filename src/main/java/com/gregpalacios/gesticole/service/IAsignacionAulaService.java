package com.gregpalacios.gesticole.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gregpalacios.gesticole.dto.AsignacionAulaDTO;
import com.gregpalacios.gesticole.model.AsignacionAula;

public interface IAsignacionAulaService extends ICRUD<AsignacionAula, Integer> {

	Page<AsignacionAula> listarPageable(Pageable pageable);

	AsignacionAula registrarTransaccional(AsignacionAulaDTO dto) throws Exception;

	AsignacionAula modificarTransaccional(AsignacionAulaDTO dto) throws Exception;

	void eliminarTransaccional(Integer id) throws Exception;
}
