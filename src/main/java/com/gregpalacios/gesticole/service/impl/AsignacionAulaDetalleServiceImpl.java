package com.gregpalacios.gesticole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gregpalacios.gesticole.model.AsignacionAulaDetalle;
import com.gregpalacios.gesticole.repo.IAsignacionAulaDetalleRepo;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.service.IAsignacionAulaDetalleService;

@Service
public class AsignacionAulaDetalleServiceImpl extends CRUDImpl<AsignacionAulaDetalle, Integer>
		implements IAsignacionAulaDetalleService {

	@Autowired
	private IAsignacionAulaDetalleRepo repo;

	@Override
	protected IGenericRepo<AsignacionAulaDetalle, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<AsignacionAulaDetalle> listarPorAsignacion(Integer idAsignacion) {
		return repo.listarPorAsignacion(idAsignacion);
	}

}
