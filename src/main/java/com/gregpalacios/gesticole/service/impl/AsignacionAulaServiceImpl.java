package com.gregpalacios.gesticole.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gregpalacios.gesticole.dto.AsignacionAulaDTO;
import com.gregpalacios.gesticole.model.AsignacionAula;
import com.gregpalacios.gesticole.model.AsignacionAulaDetalle;
import com.gregpalacios.gesticole.repo.IAsignacionAulaDetalleRepo;
import com.gregpalacios.gesticole.repo.IAsignacionAulaRepo;
import com.gregpalacios.gesticole.repo.IGenericRepo;
import com.gregpalacios.gesticole.service.IAsignacionAulaService;

@Service
public class AsignacionAulaServiceImpl extends CRUDImpl<AsignacionAula, Integer> implements IAsignacionAulaService {

	@Autowired
	private IAsignacionAulaRepo repo;

	@Autowired
	private IAsignacionAulaDetalleRepo repoDet;

	@Override
	protected IGenericRepo<AsignacionAula, Integer> getRepo() {
		return repo;
	}

	@Override
	public Page<AsignacionAula> listarPageable(Pageable pageable) {
		return repo.listarPaginado(pageable);
	}

	@Transactional
	@Override
	public AsignacionAula registrarTransaccional(AsignacionAulaDTO dto) throws Exception {
		AsignacionAula cabecera = repo.save(dto.getAsignacion());

		for (AsignacionAulaDetalle detalle : dto.getDetalle()) {
			detalle.setAsignacion(cabecera);
			repoDet.save(detalle);
		}

		return cabecera;
	}

	@Transactional
	@Override
	public AsignacionAula modificarTransaccional(AsignacionAulaDTO dto) throws Exception {
		List<AsignacionAulaDetalle> registros = repoDet.listarPorAsignacion(dto.getAsignacion().getIdAsignacion());

		for (AsignacionAulaDetalle registro : registros) {
			repoDet.deleteById(registro.getIdAsignacionDetalle());
		}

		AsignacionAula cabecera = repo.save(dto.getAsignacion());

		for (AsignacionAulaDetalle detalle : dto.getDetalle()) {
			detalle.setAsignacion(cabecera);
			repoDet.save(detalle);
		}

		return cabecera;
	}

	@Transactional
	@Override
	public void eliminarTransaccional(Integer id) throws Exception {
		List<AsignacionAulaDetalle> registros = repoDet.listarPorAsignacion(id);

		for (AsignacionAulaDetalle registro : registros) {
			repoDet.deleteById(registro.getIdAsignacionDetalle());
		}

		repo.deleteById(id);
	}

}
